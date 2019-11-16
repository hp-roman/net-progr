package chat.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;

    public static void main(String[] args) {
        Client client = new Client();
        client.taoLienKet();

    }

    Client() {
        try {
            socket = new Socket(Server.HOST, Server.PORT);
        } catch (IOException e) {
            System.out.println("Khong the ket noi den server !!!");
        }
    }

    public void taoLienKet(){
        String name;
        System.out.print("Ten: ");
        name = new Scanner(System.in).nextLine();
        System.out.print("");
        send(name + " da tham gia phong chat!");

        ReadClient readClient = new ReadClient(socket);
        WriteClient writeClient = new WriteClient(name, socket);

        readClient.start();
        writeClient.start();

    }
    private void send(String sms){
        DataOutputStream outputStream;
        try {
            outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF(sms);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // send
    class ReadClient extends Thread {
        private Socket socket;

        ReadClient(Socket s) {
            socket = s;
        }

        @Override
        public void run() {
            DataInputStream inputStream;
            try {
                inputStream = new DataInputStream(socket.getInputStream());
                while (true){
                    System.out.println(inputStream.readUTF());
                }
            } catch (IOException e) {
                System.out.println("Ngat ket noi server ...");
            }
        }
    }

    // receive
    class WriteClient extends Thread {
        private String name;
        private Socket socket;

        public WriteClient(String name, Socket socket) {
            this.name = name;
            this.socket = socket;
        }

        @Override
        public void run() {
            DataOutputStream outputStream;
            Scanner sc;
            try {
                outputStream = new DataOutputStream(socket.getOutputStream());
                sc = new Scanner(System.in);
                while (true){
                    String sms = name + ": " + sc.nextLine();
                    outputStream.writeUTF(sms);
                    if(sms.contains("bye")) break;
                }
            } catch (IOException e) {
                System.out.println("Ngat ket noi server ..");
            }
        }
    }
}
