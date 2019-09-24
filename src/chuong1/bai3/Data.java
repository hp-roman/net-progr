package chuong1.bai3;

public class Data {
    private int number = 0;
    Data(){}

    public synchronized void setNumber(int number) {
        this.number = number;
    }

    public synchronized int getNumber() {
        return number;
    }
}
