package chuong4.bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TTClient {
    public static void main(String[] args) {

    }
    private Socket socket;
    public TTClient(){
        try {
            socket = new Socket("localhost", TTServer.port);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
    public void excute(){
        System.out.print("Gui du lieu: ");
        String str = (new Scanner(System.in)).nextLine();
        try {
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF(str);
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            System.out.println("Ket qua tra ve: " + inputStream.readUTF());
            outputStream.close();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
