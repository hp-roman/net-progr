package chuong1.bai5;

public class Thread2 extends Thread {
    Data data;
    Thread2(Data data){
        this.data = data;
    }
    public int sum = 0;
    @Override
    public synchronized void run(){
        sum += data.getNumber();
        notify();
    }

}
