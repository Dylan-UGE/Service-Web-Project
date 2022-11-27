package fr.uge.bike;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

public interface IBooking extends Remote {
    Set<IBike> getAllBikes() throws RemoteException;
    IUser rent(IBike bike, IUser user) throws RemoteException;
    boolean isFree(IBike bike) throws RemoteException;
    IUser freePlace(IBike bike) throws RemoteException;
    //int getPlaceInQueue(int id) throws RemoteException;
}
