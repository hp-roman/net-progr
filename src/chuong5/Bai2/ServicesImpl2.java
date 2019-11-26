package chuong5.Bai2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ServicesImpl2 extends UnicastRemoteObject implements InterfaceServices {

    protected ServicesImpl2() throws RemoteException {
    }

    @Override
    public String func1(String[] list) throws RemoteException {
        String r;
        if(list.length != 3){
            return null;
        }
        r = list[0].replaceAll(list[1], list[2]);
        return r;
    }

    @Override
    public float func2(float[] list) throws RemoteException {
        if(list.length != 3){
            return 0f;
        }
        float p = (list[0] + list[1] + list[2])/2;
        float r = (float) Math.sqrt(p*(p - list[0])*(p - list[1])*(p - list[2]));
        return r;
    }

    @Override
    public float func2(float[] list, String c) throws RemoteException {
        float r;
        if(list.length != 3) return 0f;
        switch (c){
            case "+": r = list[0] + list[1] + list[2]; break;
            case "-": r = list[0] - list[1] - list[2]; break;
            case "*": r = list[0] * list[1] * list[2]; break;
            case "/": r = list[1] == 0 && list[2] == 0 ? 0 : list[0]/list[1]/list[2];
            default:
                System.out.println("Khong khop phep toan (+, -, *, /)");
                r = 0;
        }
        return r;
    }
}
