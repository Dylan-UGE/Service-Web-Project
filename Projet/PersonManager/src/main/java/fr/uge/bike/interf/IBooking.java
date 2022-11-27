package fr.uge.bike.interf;

import fr.uge.bike.data.Bike;
import fr.uge.bike.data.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

public interface IBooking extends Remote {
    Set<Bike> getAllBikes() throws  RemoteException;
    void  rent(Bike bike, User user) throws RemoteException;
    boolean isFree(Bike bike) throws RemoteException;
    User freePlace(Bike bike) throws RemoteException;
}
