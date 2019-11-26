package chuong5.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Compute extends Remote {
    public float cong(float a, float b) throws RemoteException;
    public float tru(float a, float b) throws RemoteException;
    public float nhan(float a, float b) throws RemoteException;
    public float chia(float a, float b) throws RemoteException;
}
