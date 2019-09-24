package chuong1.bai5;

public class Thread2 extends Thread {
    Data data;
    Thread2(Data data){
        this.data = data;
    }
    @Override
    public synchronized void run() {
        while (true){
            this.data.setSum(this.data.getSum() + this.data.getNumber());
            System.out.println("sum " + this.data.getSum());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this){
                notifyAll();
            }
            if(this.data.getNumber() == 2){
                break;
            }
        }

    }
}
