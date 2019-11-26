package chuong5.Bai1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TinhToanServices extends Remote {
    public String xoaChuoiCon(String chuoi, String chuoiCon) throws RemoteException;
    public String thayTheChuoiCon(String chuoi, String chuoiCu, String chuoiMoi) throws RemoteException;
    public float tinhToan(float a, float b, String phepToan) throws RemoteException;
    public float tinhDienTichTamGiac(float a, float b, float c) throws RemoteException;
    public float tinhDienTichHinhChuNhat(float a, float b) throws RemoteException;
}
