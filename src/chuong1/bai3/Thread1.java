package chuong1.bai3;

import java.util.Random;

// Tao so ngau nhieu sau 2s
public class Thread1 implements Runnable {
    Data data;
    Thread1(Data data){
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    @Override
    public synchronized void run(){
        while(true){

                data.setNumber(new Random().nextInt(20) + 1);
                System.out.println("Random a number: " + data.getNumber());


            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
