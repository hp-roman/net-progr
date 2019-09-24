package chuong1.bai2;

// Tinh chu vi o thread1
public class Thread3 extends Thread {
    private Thread1 thread1;
    private float perimeter;

    Thread3(Thread1 tr1){
        this.thread1 = tr1;
        perimeter = 0.0f;
    }

    @Override
    public void run(){
        perimeter = 2 * (thread1.getWidth() + thread1.getHeight());
    }

    public Thread1 getThread1() {
        return thread1;
    }

    public float getPerimeter() {
        return perimeter;
    }
}
