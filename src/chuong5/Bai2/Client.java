package chuong5.Bai2;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("Ket noi cong:" +
                "\n1. Cong 3366" +
                "\n2. Cong 7799");
        System.out.print("Chon: ");
        int c = new Scanner(System.in).nextInt();
        if(c < 1 || c > 2){
            System.out.println("Chi co 2 cong ket noi phuong thuc tu xa");
        } else {
            if(c == 1){
                new Client().service1();
            }
            if(c == 2){
                new Client().service2();
            }
        }
    }
    public void service2(){
        System.out.print("Chon phuong thuc:" +
                "\n1.Thay chuoi con trong chuoi bang chuoi moi." +
                "\n2.Tinh dien tich tam giac." +
                "\n3.Tinh toan theo phep toan." +
                "\nChon: ");
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        sc.nextLine();
        if(c < 1 || c > 3) System.out.println("Chi 3 phuong thuc tu xa.");
        else {
            try {
                Registry registry = LocateRegistry.getRegistry("localhost", 7799);
                InterfaceServices services = (InterfaceServices)registry.lookup("service2");
                if(c == 1){
                    String list[] = new String[3];
                    System.out.print("Chuoi: ");
                    list[0] = sc.nextLine();
                    System.out.print("Chuoi can thay the: ");
                    list[1] = sc.nextLine();
                    System.out.print("Chuoi moi: ");
                    list[2] = sc.nextLine();
                    System.out.println("Chuoi sau khi thay the: " + services.func1(list));
                }
                if(c == 2){
                    float list[] = new float[3];
                    System.out.print("Canh a = ");
                    list[0] = sc.nextFloat();
                    System.out.print("Canh b = ");
                    list[1] = sc.nextFloat();
                    System.out.print("Canh c = ");
                    list[2] = sc.nextFloat();
                    System.out.println("Dien tich tam giac: " + services.func2(list));
                }
                if(c == 3){
                    float list[] = new float[3];
                    System.out.print("Chon phep toan (+, -, *, /): ");
                    String ch = sc.nextLine();
                    System.out.print("So a = ");
                    list[0] = sc.nextFloat();
                    System.out.print("So b = ");
                    list[1] = sc.nextFloat();
                    System.out.print("So c = ");
                    list[2] = sc.nextFloat();
                    System.out.println("Ket qua thuc hien: " + services.func2(list, ch));
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    }
    public void service1(){
        System.out.print("Chon phuong thuc:" +
                "\n1.Xoa chuoi con trong chuoi." +
                "\n2.Tinh dien tich hinh chu nhat." +
                "\n3.Tinh toan theo phep toan." +
                "\nChon: ");
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        sc.nextLine();
        if(c < 1 || c > 3) System.out.println("Chi 3 phuong thuc tu xa.");
        else {
            try {
                Registry registry = LocateRegistry.getRegistry("localhost", 3366);
                InterfaceServices services = (InterfaceServices) registry.lookup("service1");
                if(c == 1){
                    String list[] = new String[2];
                    System.out.print("Chuoi: ");
                    list[0] = sc.nextLine();
                    System.out.print("Chuoi con can xoa: ");
                    list[1] = sc.nextLine();
                    System.out.println("Chuoi sau khi xoa chuoi con: " + services.func1(list));
                }
                if(c == 2){
                    float list[] = new float[2];
                    System.out.print("Chieu dai: ");
                    list[0] = sc.nextFloat();
                    System.out.print("Chieu rong: ");
                    list[1] = sc.nextFloat();
                    System.out.println("Dien tich hinh chu nhat: " + services.func2(list));
                }
                if(c == 3){
                    float list[] = new float[2];
                    System.out.print("Chon phep toan (+, -, *, /): ");
                    String ch = sc.nextLine();
                    System.out.print("So a = ");
                    list[0] = sc.nextFloat();
                    System.out.print("So b = ");
                    list[1] = sc.nextFloat();
                    System.out.println("Ket qua tinh: " + services.func2(list, ch));
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    }
}
