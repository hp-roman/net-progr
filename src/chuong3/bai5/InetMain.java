package chuong3.bai5;

import java.net.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InetMain {
    private static String[] list = new String[]{
            "google.com",
            "fb.com",
            "youtube.com",
            "gmail.com",
            "kenh14.vn"
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter address url: ");
        String url_str = sc.nextLine();
        if(url_str.indexOf("http://") == -1){
            url_str = "http://" + url_str;
        }
        URL url = null;
        InetAddress inet = null;
        try {
            url = new URL(url_str);
            inet = InetAddress.getByName(url.getHost());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        boolean exist = true;
        String[] list_ip = new String[list.length];
        for(int i = 0; i < list.length; i++){
            if(list[i].equals(inet.getHostName())) {
                exist = false;
            }
            try {
                list_ip[i] = InetAddress.getByName(list[i]).getHostAddress();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        for(int i = 0; i < list.length; i++){
            if(list_ip[i].equals(inet.getHostAddress())){
                exist = false;
                break;
            }
        }

        if(exist == true){
            System.out.println("Connected !!!");
        } else {
            System.out.println("Cannot access !!!");
        }


    }
}
