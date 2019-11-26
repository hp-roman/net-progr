package chuong4.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    private DatagramSocket serverSocket;
    public static final int PORT = 3366;
    public static void main(String[] args) {
        new Server();

    }

    Server(){
        try {
            serverSocket = new DatagramSocket(PORT);
            DatagramPacket client;
            byte data[] = new byte[60000];
            while(true){
                client = new DatagramPacket(data, data.length);
                serverSocket.receive(client);
                String sms = new String(client.getData(), 0, client.getLength());
                System.out.println(sms);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
