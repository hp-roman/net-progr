package chuong1.bai2;

// Tinh dien tich o thread1
public class Thread2 extends Thread {
    private Thread1 thread1;
    private float area;

    Thread2(Thread1 tr1){
        this.thread1 = tr1;
        area = 0.0f;
    }

    @Override
    public void run(){
        area = thread1.getHeight() * thread1.getWidth();
    }

    public float getArea() {
        return area;
    }

    public Thread1 getThread1() {
        return thread1;
    }
}
