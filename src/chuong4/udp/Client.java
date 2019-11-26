package chuong4.udp;

import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        new Client();

    }
    private DatagramSocket socket;

    Client(){
        try {
            socket = new DatagramSocket();

            InetAddress ip = InetAddress.getByName("localhost");
            byte data[] = "Hello man".getBytes();


            DatagramPacket outPacket = new DatagramPacket(data, data.length,  ip, Server.PORT);
            socket.send(outPacket);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
