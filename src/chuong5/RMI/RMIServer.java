package chuong5.RMI;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(3366);
            Registry registry = LocateRegistry.getRegistry("localhost", 3366);
            registry.rebind("compute", new Computing());

            System.out.println("Server is listening ...");
        } catch (Exception e) {
            System.out.println("Error: " + e);

        }
    }
}
