package chuong3;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.Date;
import java.util.Scanner;

public class InetMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println(
                "1. Lay thong tin tu website bao gom (ten file, ten host, so hieu cong, kieu giao thuc).\n" +
                "2. Lay noi dung cua website su dung getContent().\n" +
                "3. Lay localhost, dia chi website su dung getLocalHost(), getByName().\n" +
                "4. " +
                "" +
                "");
        bai4("http://qlht.ued.udn.vn");

    }
    public static void bai1(String url_str){
        URL url = null;
        try {
            url = new URL(url_str);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println("File name: " + url.getFile());
        System.out.println("Host name: " + url.getHost());
        System.out.println("Port: " + url.getPort());
        System.out.println("Protocol: " + url.getProtocol());
    }
    public static void bai2(String url_str){
        URL url = null;
        try {
            url = new URL(url_str);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            DataInputStream dis = new DataInputStream((InputStream) url.getContent());
            String line;
            while((line = dis.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void bai3(String url_str){
        URL url = null;
        try {
            url = new URL(url_str);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            InetAddress inet = InetAddress.getByName(url.getHost());
            System.out.println("Localhost: " + inet.getLocalHost());
            System.out.println("IP: " + inet.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
    public static void bai4(String url_str){
        URL url = null;
        try {
            url = new URL(url_str);
            URLConnection url_con = url.openConnection();
            System.out.println("Ngay tao: " + new Date(url_con.getIfModifiedSince()).toString());
            System.out.println("Chinh sua lan cuoi: " + new Date(url_con.getLastModified()).toString());
            System.out.println("Ngay het han: " + new Date(url_con.getExpiration()).toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
