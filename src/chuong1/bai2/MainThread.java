package chuong1.bai2;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {

        Thread1 tr1 = new Thread1();
        Thread2 tr2 = new Thread2(tr1);
        Thread3 tr3 = new Thread3(tr1);

        tr1.start();
        tr1.join();
        tr2.start();
        tr3.start();

        System.out.println("width = " + tr1.getWidth() + ", height = " + tr1.getHeight());
        System.out.println("Area: " + tr2.getArea());
        System.out.println("Perimeter: " + tr3.getPerimeter());

    }
}
