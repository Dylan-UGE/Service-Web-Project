package fr.eiffel.bike.corp;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

public interface IBooking extends Remote {
    Set<Bike> getAllBikes();
    void  rent(Bike bike, User user) throws RemoteException;
    boolean isFree(Bike bike) throws RemoteException;
    User freePlace(Bike bike) throws RemoteException;
    //int getPlaceInQueue(int id) throws RemoteException;
}
