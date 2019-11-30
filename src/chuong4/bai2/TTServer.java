package chuong4.bai2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
        String operator = "+-*/";
        readUTF.trim();
        String OP, Op1, Op2;
        if(operator.indexOf(readUTF.charAt(0)) != -1){
            OP = readUTF.substring(0, readUTF.indexOf(" "));
            Op1 = readUTF.substring(readUTF.indexOf(" "), readUTF.lastIndexOf(" "));
            Op2 = readUTF.substring(readUTF.lastIndexOf(" "), readUTF.length());
        }


        return r;
    }
}
