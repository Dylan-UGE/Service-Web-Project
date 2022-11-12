package fr.eiffel.bike.corp;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBooking extends Remote {
    void  rent(int id, User user) throws RemoteException;
    boolean isFree(int id) throws RemoteException;
    User freePlace(int id) throws RemoteException;
    //int getPlaceInQueue(int id) throws RemoteException;
}
