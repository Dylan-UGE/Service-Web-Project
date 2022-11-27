package fr.uge.bike.interf;

import fr.uge.bike.data.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

public interface IBooking extends Remote {
    Set<IBike> getAllBikes() throws  RemoteException;
    void  rent(IBike bike, User user) throws RemoteException;
    boolean isFree(IBike bike) throws RemoteException;
    User freePlace(IBike bike) throws RemoteException;
}
