package fr.uge.bike.interf;

import fr.uge.bike.data.Bike;
import fr.uge.bike.data.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IRentalBikes extends Remote {
    boolean addBike(Bike bike) throws  RemoteException;
    void rentBike(User user, Bike bike) throws RemoteException;
    User returnBike(User user, Bike bike) throws RemoteException;
    List<Bike> getBikes() throws RemoteException;
    List<Bike> rentedBikeOfUser(User user) throws RemoteException;
}
