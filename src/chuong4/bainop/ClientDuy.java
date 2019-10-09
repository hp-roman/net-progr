package chuong4.bainop;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientDuy {
    private Socket s;
    ClientDuy(){
        try {
            s = new Socket("localhost", Server.defaultPort);
            OutputStream ops = s.getOutputStream();
            System.out.print("Message: ");
            String temp = "Duy: " + new Scanner(System.in).nextLine();
            for (int i = 0; i < temp.length(); i++) {
                ops.write((int) (temp.charAt(i)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new ClientDuy();
    }
}
