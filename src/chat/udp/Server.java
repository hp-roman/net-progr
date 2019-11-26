package chat.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private DatagramSocket socket;
    private ArrayList<DatagramPacket> list;
    public static int port = 3366;
    public static String host = "localhost";


    public static void main(String[] args) {
        Server server = new Server();
        server.listen();
    }

    Server() {
        try {
            socket = new DatagramSocket(port);
            list = new ArrayList<>();
        } catch (SocketException e) {
            System.out.println("Loi server ..");
        }
    }

    public void listen() {
        System.out.println("Server is listening to ...");
        byte temp[] = new byte[1024];
        DatagramPacket packet = new DatagramPacket(temp, temp.length);
        while (true) {
            try {
                socket.receive(packet);
                list.add(packet);
                System.out.println("So nguoi ket noi: " + list.size() + ", port: " + packet.getPort());
                String sms = new String(packet.getData(), 0, packet.getLength());
                System.out.println(sms);
                for(DatagramPacket p: list){
                    socket.send(p);
                }

            } catch (IOException e) {
                System.out.println("Loi du lieu ..");
            }
        }

    }

}
