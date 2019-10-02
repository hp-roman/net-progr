package chuong3.bai6;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class InetMain6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tmp;
        while(true){
            System.out.print("Enter address url: ");
            tmp = sc.nextLine();
            InetAddress inet = null;
            try {
                inet = InetAddress.getByName(tmp);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            System.out.println("Host name: " + inet.getHostName());
            System.out.println("IP Address: " + inet.getHostAddress());
            System.out.print("yes/no: ");
            if(sc.nextLine().equals("no")){
                break;
            }
        }
    }
}
