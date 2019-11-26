package chuong5.RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) {
        Compute compute;
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 3366);
            compute = (Compute) registry.lookup("compute");
            System.out.println(compute.tru(10, 15));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
