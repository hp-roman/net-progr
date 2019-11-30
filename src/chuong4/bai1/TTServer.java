package chuong4.bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TTServer {
    public static void main(String[] args) {
//        TTServer server = new TTServer();
//        server.excute();

    }

    private ServerSocket serverSocket;
    public static final int port = 3366;

    public TTServer() {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public void excute() {
        while (true) {
            try {
                Socket s = serverSocket.accept();
                DataInputStream inputStream = new DataInputStream(s.getInputStream()); // Stream doc du lieu
                String result = calculate(inputStream.readUTF()); // Doc du lieu luu vao String
                DataOutputStream outputStream = new DataOutputStream(s.getOutputStream()); // Stream ghi du lieu
                outputStream.writeUTF(result); // Ghi du lieu result
                outputStream.close();
                inputStream.close();
                s.close();
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
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
