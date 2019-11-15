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

        System.out.println(client.result("25"));

    }

    public String result(String mess){
        String response = "";
        InputStreamReader ips;
        BufferedReader ipstr;
        OutputStream os;
        DataOutputStream opstr;

        try {
            ips = new InputStreamReader(s.getInputStream());
            ipstr = new BufferedReader(ips);
            os = s.getOutputStream();
            opstr = new DataOutputStream(os);

            opstr.writeBytes(mess);
            opstr.write(13);
            opstr.write(10);
            opstr.flush();

            System.out.println(ipstr.readLine());


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
