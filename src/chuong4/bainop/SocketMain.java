package chuong4.bainop;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketMain {
    static class Server{
       ServerSocket ss;
       Server(){
           try {
               ss = new ServerSocket(5000);
               System.out.print("Listening " + ss.getLocalPort() + " ...");
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }
    public static void main(String[] args) {
        Server s = new Server();
    }
}
