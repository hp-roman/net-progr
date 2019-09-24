package chuong1.bai1;

// In so nguyen chan nho hon n
public class Thread2 extends Thread{
    private int number;

    Thread2(int n){
        this.number = n;
    }

    @Override
    public void run(){
        for(int i = 0; i < number; i++){
            if(i % 2 == 0) System.out.print(i + " ");
        }
    }
}
