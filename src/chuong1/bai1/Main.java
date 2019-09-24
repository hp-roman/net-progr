package chuong1.bai1;

public class Main {
    public static void main(String[] args) {
        int n = 10;

        new Thread1(n).start();
        new Thread2(n).start();
        new Thread3(n).start();
        new Thread4().start();

    }
}
