package chuong5.Bai2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceServices extends Remote {
    public String func1(String list[]) throws RemoteException;
    public float func2(float list[]) throws RemoteException;
    public float func2(float list[], String c) throws RemoteException;
}
