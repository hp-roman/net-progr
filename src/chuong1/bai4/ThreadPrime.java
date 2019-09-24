package chuong1.bai4;

public class ThreadPrime extends Thread {
    private int number;
    ThreadPrime(int number){
        this.number = number;
    }
    @Override
    public synchronized void run(){
        boolean check = true;
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0){
                check = false;
                break;
            }
        }
        if(check == true){
            System.out.print(number + " ");
        }
    }
}
