package chuong4;

import java.io.*;
import java.net.Socket;

public class Client {
    private Socket s;
    Client(){
        try {
            s = new Socket(Server.HOST, Server.PORT_DEF);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();

        System.out.println(client.result("12"));

    }

    public String result(String mess){
        String response = "";
        BufferedWriter os;
        BufferedReader is;
        InputStreamReader isr = new InputStreamReader(System.in);

        try {
            os = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            is = new BufferedReader(new InputStreamReader(s.getInputStream()));
            os.write(mess);
            os.flush();
            System.out.println();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    public Socket getS() {
        return s;
    }

    public void setS(Socket s) {
        this.s = s;
    }
}
