package fr.uge.bike;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBike extends Remote {
    int getId() throws RemoteException;
    String getBrand() throws RemoteException;
    String getColor() throws RemoteException;
    int getSize() throws RemoteException;
    void setId(int id) throws RemoteException;
    void setBrand(String brand) throws RemoteException;
    void setColor(String color) throws RemoteException;
    void setSize(int size) throws RemoteException;
}
