package chuong1.bai5;

public class Thread1 extends Thread{
    Data data;
    Thread1(Data data){
        this.data = data;
    }
    @Override
    public synchronized void run(){
        for(int i = 2; i <= 1000; i++){
            if(isPrime(i) == true){
                this.data.setNumber(i);
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private boolean isPrime(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}
