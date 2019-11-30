package chuong4.bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SSServer {
    public static void main(String[] args) {

    }
    private ServerSocket serverSocket;
    public static final int port = 3366;
    public SSServer(){
        try {
            serverSocket = new ServerSocket();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
    public void excute(){
        while (true){
            try {
                Socket s = serverSocket.accept();
                new Calculate(s).start();
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }

        }
    }
    static class Calculate extends Thread{
        private Socket s;

        public Calculate(Socket s) {
            this.s = s;
        }
        @Override
        public void run(){
            try {
                DataInputStream inputStream = new DataInputStream(s.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
                String result = calculate(inputStream.readUTF());
                outputStream.writeUTF(result);
                outputStream.close();
                inputStream.close();
                s.close();
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }

        private String calculate(String readUTF) {
            String r = "";
            boolean isNumber = true;
            for(byte c : readUTF.getBytes()){
                if(c > '9' || c < '0'){
                    isNumber = false;
                    break;
                }
            }
            if(isNumber){
                // Copy code
            }


            return r;
        }
    }
}
