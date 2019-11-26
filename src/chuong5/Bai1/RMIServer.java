package chuong5.Bai1;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static final int port = 3366;
    public static final String host = "localhost";
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(port);
            Registry registry = LocateRegistry.getRegistry(host, port);
            registry.rebind("tinhtoan", new TinhToanImpl());
            System.out.println("Server is listening to 3366 ..");
        } catch (RemoteException e) {
            System.out.println("Loi server ..");
        }
    }
}
