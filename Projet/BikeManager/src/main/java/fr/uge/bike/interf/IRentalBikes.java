package fr.uge.bike.interf;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

public interface IRentalBikes extends Remote {
    void addBike(IUser user, String brand, String color, int size) throws  RemoteException;
    void rentBike(IUser user, IBike bike) throws RemoteException;
    void returnBike(IBike bike) throws RemoteException;
    Set<IBike> getBikes() throws RemoteException;
}
