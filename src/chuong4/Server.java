package chuong4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;

public class Server {
    private ServerSocket ss;
    private Socket s;
    public static final int PORT_DEF = 7799;
    public static final String HOST = "127.0.0.1";

    public static void main(String[] args) {
        new Server();
    }

    Server(){
        try {
            ss = new ServerSocket(PORT_DEF);
            System.out.println("Listening to " + PORT_DEF + " ...");
            while(true){
                s = ss.accept();
                new Task1().start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    class Task1 extends Thread {
        @Override
        public void run(){
            BufferedReader br;
            BufferedWriter bw;
            try {
                br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                String result = br.readLine();
                result = computing(result);
                bw.write(result);
                bw.flush();
                System.out.println(result);
                br.close();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String computing(String data){
        boolean c = true;
        for(int i = 0; i < data.length(); i++){
            char cIndex = data.charAt(i);
            if(cIndex > '9' || cIndex < '0'){
                c = false;
                break;
            }
        }
        if(c == false) return "Khong phai so nguyen";
        else{
            String[] aNumber = {"Muoi ", "Mot ", "Hai ", "Ba ", "Bon ", "Nam ", "Sau ", "Bay ", "Tam ", "Chin "};
            String result = null;
            int newData = Integer.parseInt(data);
            if(newData >= 1 && newData <= 10){
                return aNumber[newData % 10];
            }else {
                if(newData >= 100) return "So qua lon !!!";
                String lastNumber = newData % 10 == 5 ? "Lam" : aNumber[newData % 10];
                if(newData/10 == 1){
                    result = aNumber[0] + lastNumber;
                } else {
                    result = aNumber[newData/10] + aNumber[0] + lastNumber;
                }
                return result;
            }
        }

    }

    public Socket getS() {
        return s;
    }

    public ServerSocket getSs() {
        return ss;
    }

    public void setS(Socket s) {
        this.s = s;
    }

    public void setSs(ServerSocket ss) {
        this.ss = ss;
    }
}
