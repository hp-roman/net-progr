package chuong5.Bai2;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        RMIServer rmiServer = new RMIServer();
        rmiServer.excute();
    }

    public void excute(){
        new Service1("localhost", 3366).start();
        new Service2("localhost", 7799).start();
    }
    class Service1 extends Thread {
        private String host;
        private int port;

        public Service1(String host, int port) {
            this.host = host;
            this.port = port;
        }
        public void run(){
            try {
                LocateRegistry.createRegistry(port);
                Registry registry = LocateRegistry.getRegistry(host, port);
                registry.rebind("service1", new ServicesImpl1());
                System.out.println("Service1 dang lang nghe cong: " + port);
            } catch (RemoteException e) {
                System.out.println("Khong the lang nghe cong: " + port);
            }
        }
    }
    class Service2 extends Thread {
        private String host;
        private int port;

        public Service2(String host, int port) {
            this.host = host;
            this.port = port;
        }

        public void run(){
            try {
                LocateRegistry.createRegistry(port);
                Registry registry = LocateRegistry.getRegistry(host, port);
                registry.rebind("service2", new ServicesImpl2());
                System.out.println("Service2 dang lang nghe cong: " + port);
            } catch (RemoteException e) {
                System.out.println("Khong the lang nghe cong: " + port);
            }
        }
    }
}
