package chuong1.bai4;

import java.util.Scanner;

public class MainThread {

    public static void main(String[] args) throws InterruptedException {
        int a, b;
        Scanner sc = new Scanner(System.in);
        System.out.print("a = ");
        a = sc.nextInt();
        System.out.print("b = ");
        b = sc.nextInt();

        for(int i = a; i <= b; i++){
            ThreadPrime threadPrime = new ThreadPrime(i);
            threadPrime.start();
            threadPrime.join();
        }
    }
}
