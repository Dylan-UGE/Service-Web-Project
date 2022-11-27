package fr.uge.bike.interf;

import fr.uge.bike.data.Bike;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IRentalBikes extends Remote {
    void addBike(IUser user, String brand, String color, int size) throws  RemoteException;
    void rentBike(IUser user, Bike bike) throws RemoteException;
    void returnBike(Bike bike) throws RemoteException;
    List<Bike> getBikes() throws RemoteException;
}
