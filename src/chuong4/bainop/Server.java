package chuong4.bainop;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket ss;
    public static final int defaultPort = 5000;

    Server(){
        try {
            ss = new ServerSocket(defaultPort);
            Socket s;
            RequestProcessing rps;
            while(true){
                s = ss.accept();
                rps = new RequestProcessing(s);
                rps.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
    }

    public ServerSocket getSs() {
        return ss;
    }
}
