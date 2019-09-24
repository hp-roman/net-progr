package chuong1.bai1;

// In cac so nguyen tu 1 - n
public class Thread3 extends Thread {
    private int number;

    Thread3(int n){
        this.number = n;
    }

    @Override
    public void run(){
        for(int i = 1; i <= number; i++) {
            System.out.print(i + " ");
        }
    }
}
