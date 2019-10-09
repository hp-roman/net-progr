package chuong4.bainop;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RequestProcessing extends Thread{
    private Socket chanel;

    RequestProcessing(Socket s){
        chanel = s;
    }
    @Override
    public void run(){
        InputStream ips;
        try {
            ips = chanel.getInputStream();
            while(true){
                int i = ips.read();
                if(i == -1) break;
                System.out.print((char)(i));
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Socket getChanel() {
        return chanel;
    }
}
