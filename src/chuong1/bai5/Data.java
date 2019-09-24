package chuong1.bai5;

public class Data {
    private int number;

    public synchronized int getNumber() {
        return number;
    }

    public synchronized void setNumber(int number) {
        this.number = number;
    }
}
