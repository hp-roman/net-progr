package chuong5.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Computing extends UnicastRemoteObject implements Compute {

    Computing() throws RemoteException{
        super();
    }

    @Override
    public float cong(float a, float b) throws RemoteException {
        return a + b;
    }

    @Override
    public float tru(float a, float b) throws RemoteException {
        return a - b;
    }

    @Override
    public float nhan(float a, float b) throws RemoteException {
        return a * b;
    }

    @Override
    public float chia(float a, float b) throws RemoteException {
        return b == 0 ? 0 : a/b;
    }
}
