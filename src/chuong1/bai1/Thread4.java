package chuong1.bai1;

// In cac chu cai A - Z

public class Thread4 extends Thread {
    Thread4(){}

    @Override
    public void run(){
        for(int i = 'A'; i <= 'Z'; i++){
            System.out.print((char)(i) + " ");
        }

    }
}
