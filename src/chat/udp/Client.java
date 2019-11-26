package chat.udp;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    private DatagramSocket socket;

    public static void main(String[] args) {
        Client client = new Client();
        client.excute();
    }

    public void excute(){
        System.out.print("Ten: ");
        String name = new Scanner(System.in).nextLine();
        byte temp[] = new byte[1024];
        try {
            InetAddress inetAddress = InetAddress.getByName(Server.host);
            DatagramPacket packet = new DatagramPacket(temp, temp.length, inetAddress, Server.port);
            packet.setData((name + " da tham gia phong chat ..").getBytes());
            socket.send(packet);
            //new Send(name, packet).start();
            new Read(packet).start();
        } catch (UnknownHostException e) {
            System.out.println("Khong tim thay server ..");
        } catch (IOException e) {
            System.out.println("Khong gui duoc du lieu ...");
        }

    }

    Client(){
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            System.out.println("Loi ket noi ...");
        }
    }

    private class Send extends Thread{
        private String name;
        private DatagramPacket packet;

        public Send(String name, DatagramPacket packet) {
            this.name = name;
            this.packet = packet;
        }
        @Override
        public void run(){
            Scanner sc = new Scanner(System.in);
            while (true){
                try {
                    String sms = sc.nextLine();
                    this.packet.setData((name + ": " + sms).getBytes());
                    socket.send(this.packet);
                } catch (IOException e) {
                    System.out.println("Khong the ket noi den Server ..");
                }

            }
        }
    }
    private class Read extends Thread {
        private DatagramPacket packet;
        Read(DatagramPacket packet){
            this.packet = packet;
        }
        @Override
        public void run(){
            while (true){
                try {
                    socket.receive(packet);
                    String sms = new String(packet.getData());
                    System.out.println(sms);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
