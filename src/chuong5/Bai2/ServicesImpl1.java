package chuong5.Bai2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ServicesImpl1 extends UnicastRemoteObject implements InterfaceServices {

    protected ServicesImpl1() throws RemoteException {
    }

    @Override
    public String func1(String[] list) throws RemoteException {
        String r;
        if(list.length != 2){
            return null;
        }
        r = list[0].replaceAll(list[1], "");
        return r;
    }

    @Override
    public float func2(float[] list) throws RemoteException {
        if(list.length != 2){
            return 0.0f;
        }
        return list[0] * list[1];
    }

    @Override
    public float func2(float[] list, String c) throws RemoteException {
        if(list.length != 2){
            return 0.0f;
        }
        float r;
        switch (c){
            case "+": r = list[0] + list[1]; break;
            case "-": r = list[0] - list[1]; break;
            case "*": r = list[0] * list[1]; break;
            case "/": r = list[1] == 0 ? 0 : list[0] / list[1];
            default:
                r = 0;
        }
        return r;
    }
}
