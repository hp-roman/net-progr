package chuong5.Bai1;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        System.out.println("Su dung ham dich vu tu xa." +
                "\n1. Xoa chuoi con." +
                "\n2. Thay the chuoi con bang mot chuoi khac." +
                "\n3. Thuc hien phep tich." +
                "\n4. Tinh dien tich tam giac." +
                "\n5. Tinh dien tich hinh chu nhat.");
        System.out.print("Chon: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TinhToanServices tinhToan = null;
        Registry registry = LocateRegistry.getRegistry(RMIServer.host, RMIServer.port);
        tinhToan = (TinhToanServices) registry.lookup("tinhtoan");
        if(n > 5 || n < 1) System.out.println("He thong tu xa chi co nhung phuong thuc tren.");
        else {
            if(n == 1){
                System.out.print("Chuoi thuc: ");
                sc.nextLine();
                String t = sc.nextLine();
                System.out.print("Chuoi cu: ");
                String t1 = sc.nextLine();
                String r = tinhToan.xoaChuoiCon(t, t1);
                System.out.println("Chuoi sau khi xoa: " + r);
            }
            if(n == 2){
                System.out.print("Chuoi thuc: ");
                sc.nextLine();
                String t = sc.nextLine();
                System.out.print("Chuoi con: ");
                String t1 = sc.nextLine();
                System.out.print("Chuoi thay the: ");
                String t2 = sc.nextLine();
                String r = tinhToan.thayTheChuoiCon(t, t1, t2);
                System.out.println("Chuoi sau khi thay the: " + r);

            }
            if(n == 3){
                System.out.print("Chon phep toan: (+ , -, *, /): ");
                sc.nextLine();
                String t = sc.nextLine();
                System.out.print("So a = ");
                float a = sc.nextFloat();
                System.out.print("So b = ");
                float b = sc.nextFloat();
                float r = tinhToan.tinhToan(a, b , t);
                if(r == -0.1f){
                    System.out.println("Khong the tinh..");
                }else System.out.println("Ket qua tinh: " + r);
            }
            if(n == 4){
                float a, b, c;
                System.out.print("Do dai canh a = ");
                a = sc.nextFloat();
                System.out.print("Do dai canh b = ");
                b = sc.nextFloat();
                System.out.print("Do dai canh c = ");
                c = sc.nextFloat();
                float r = tinhToan.tinhDienTichTamGiac(a, b, c);

                System.out.println("Dien tich tam giac: " + r);

            }
            if(n == 5){
                float a, b;
                System.out.print("Chieu dai: ");
                a = sc.nextFloat();
                System.out.print("Chieu rong: ");
                b = sc.nextFloat();
                float r = tinhToan.tinhDienTichHinhChuNhat(a, b);
                System.out.println("Dien tich hinh chu nhat: " + r);
            }
        }
    }
}
