package chuong5.Bai1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TinhToanImpl extends UnicastRemoteObject implements TinhToanServices {
    protected TinhToanImpl() throws RemoteException {
    }

    @Override
    public String xoaChuoiCon(String chuoi, String chuoiCon) throws RemoteException {
        if(chuoi.contains(chuoiCon)){
            chuoi = chuoi.replaceAll(chuoiCon, "");
        }
        return chuoi;
    }

    @Override
    public String thayTheChuoiCon(String chuoi, String chuoiCu, String chuoiMoi) throws RemoteException {
        if (chuoi.contains(chuoiCu)){
            chuoi = chuoi.replaceAll(chuoiCu, chuoiMoi);
        }
        return chuoi;
    }

    @Override
    public float tinhToan(float a, float b, String phepToan) throws RemoteException {
        float r = 0.0f;
        switch (phepToan){
            case "+": r = a + b; break;
            case "-": r = a - b; break;
            case "*": r = a * b; break;
            case "/": if(b != 0) r = a / b; break;
            default: r = -0.1f;
        }
        return r;
    }

    @Override
    public float tinhDienTichTamGiac(float a, float b, float c) throws RemoteException {
        double p = (double) (a + b + c)/2;
        return (float) Math.sqrt(p*(p - a)*(p - b)*(p - c));
    }

    @Override
    public float tinhDienTichHinhChuNhat(float a, float b) throws RemoteException {
        return a * b;
    }
}
