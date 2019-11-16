package chat.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static final int PORT = 3687;
    public static final String HOST = "localhost";
    private ArrayList<Socket> sockets;
    private ServerSocket serverSocket;

    public static void main(String[] args) {

        Server server = new Server();
        server.taoLienKet();
    }

    Server() {
        sockets = new ArrayList<>();
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening " + PORT + " ...");
        } catch (IOException e) {
            System.out.println("Loi tao server ..");
        }
    }

    public void taoLienKet() {
        try {
            Socket s;
            ServerS serverS;
            while (true) {
                s = serverSocket.accept();
                sockets.add(s);
                System.out.println("So nguoi tham gia vao phong chat: " + sockets.size());
                sendTo("So nguoi tham gia vao phong chat: " + sockets.size());
                serverS = new ServerS(s);
                serverS.start();

            }
        } catch (IOException e) {
            System.out.println("Loi server ..");
        }
    }

    class ServerS extends Thread {
        Socket socket;

        ServerS(Socket s) {
            socket = s;
        }

        @Override
        public void run() {
            DataInputStream inputStream;
            try {
                inputStream = new DataInputStream(socket.getInputStream());
                while (true) {
                    String sms = inputStream.readUTF();
                    if (sms.contains("bye")) {
                        sendTo(sms, socket);
                        sockets.remove(socket);
                        inputStream.close();
                        socket.close();
                        continue;
                    }
                    else{
                        System.out.println(sms);
                        sendTo(sms, socket);
                    }
                }

            } catch (IOException e) {
                System.out.println("Ngung ket noi ..");
            }

        }
    }

    public void sendTo(String sms) {
        DataOutputStream outputStream;
        try {
            for (Socket s : sockets) {
                outputStream = new DataOutputStream(s.getOutputStream());
                outputStream.writeUTF(sms);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendTo(String sms, Socket socket) {
        DataOutputStream outputStream;
        for (Socket s : sockets) {
            if (s.getPort() == socket.getPort()) continue;
            try {
                outputStream = new DataOutputStream(s.getOutputStream());
                outputStream.writeUTF(sms);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
