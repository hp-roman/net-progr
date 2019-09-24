package chuong1.bai5;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Data dt = new Data();

        Thread2 thr2 = new Thread2(dt);
        Thread1 thr1 = new Thread1(dt);
        thr1.setPriority(Thread.MAX_PRIORITY);
        thr1.start();
        thr2.start();
        System.out.println("Sum: " + dt.getSum());

    }
}
