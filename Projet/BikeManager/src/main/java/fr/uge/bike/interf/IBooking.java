package fr.uge.bike.interf;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

public interface IBooking extends Remote {
    Set<IBike> getAllBikes() throws RemoteException;
    Set<IBike> getBikeRentByUser(IUser user) throws RemoteException;
    void  rent(IBike bike, IUser user) throws RemoteException;
    boolean isFree(IBike bike) throws RemoteException;
    IUser freePlace(IBike bike) throws RemoteException;
}
