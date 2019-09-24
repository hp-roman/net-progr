package chuong1.bai3;

public class MainThread {
    public static void main(String[] args) {
        Data data = new Data();
        Thread1 thr1 = new Thread1(data);
        Thread2 thr2 = new Thread2(thr1.getData());

        new Thread(thr1).start();
        new Thread(thr2).start();

    }
}
