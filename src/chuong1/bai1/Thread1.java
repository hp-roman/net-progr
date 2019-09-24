package chuong1.bai1;

// In so nguyen le nho hon n
public class Thread1 extends Thread {
    private int number;
    Thread1(int n){
        this.number = n;
    }
    @Override
    public void run(){
        for(int i = 0; i < number; i++) {
            if (i % 2 != 0) System.out.print(i + " ");
        }
    }
}
