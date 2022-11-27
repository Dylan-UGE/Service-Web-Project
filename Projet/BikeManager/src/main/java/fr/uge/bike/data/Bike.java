package fr.uge.bike.data;

import fr.uge.bike.interf.IBike;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Bike extends UnicastRemoteObject implements IBike {
    private int id;
    private String brand;
    private String color;
    private int size;

    //Field owner

    public Bike() throws RemoteException {}

    public Bike(int id, String brand, String color, int size) throws RemoteException {
        super();
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.size = size;
        //this.feedback = new Feedback();
    }

    public int getId() throws RemoteException{
        return id;
    }

    public String getBrand() throws RemoteException {
        return brand;
    }

    public String getColor() throws RemoteException {
        return color;
    }

    public int getSize() throws RemoteException {
        return size;
    }

    @Override
    public void setId(int id) throws RemoteException {
        this.id = id;
    }

    @Override
    public void setBrand(String brand) throws RemoteException {
        this.brand = brand;
    }

    @Override
    public void setColor(String color) throws RemoteException {
        this.color = color;
    }

    @Override
    public void setSize(int size) throws RemoteException {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", size=" + size +
                '}';
    }
}
