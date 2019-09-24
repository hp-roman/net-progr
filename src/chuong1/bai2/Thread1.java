package chuong1.bai2;

import java.util.Scanner;

// Nhap vao 2 so thuc 2 canh cua hinh chu nhat
public class Thread1 extends Thread {
    private float width, height;

    Thread1(){
        this.width = this.height = 0.0f;
    }

    @Override
    public void run(){
        System.out.print("width = ");
        width = new Scanner(System.in).nextFloat();

        System.out.print("height = ");
        height = new Scanner(System.in).nextFloat();
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }
}
