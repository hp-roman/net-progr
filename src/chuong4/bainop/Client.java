package chuong4.bainop;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private Socket s;

    Client(){
        try {
            s = new Socket("localhost", Server.defaultPort);
            OutputStream ops = s.getOutputStream();
            System.out.print("Message: ");
            Scanner sc = new Scanner(System.in);
            String temp = "Phi: "  + sc.nextLine();
            for (int i = 0; i < temp.length(); i++) {
                ops.write((int) (temp.charAt(i)));
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
        Client client = new Client();
    }

    public Socket getS() {
        return s;
    }
}
