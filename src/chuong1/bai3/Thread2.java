package chuong1.bai3;

// In so nguyen vua random duoc
public class Thread2  implements Runnable {
    Data data;
    Thread2(Data data){
        this.data = data;
    }
    @Override
    public synchronized void run(){
        while(true){

                System.out.println(data.getNumber() + "^2 = " + Math.pow(data.getNumber(), 2));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
