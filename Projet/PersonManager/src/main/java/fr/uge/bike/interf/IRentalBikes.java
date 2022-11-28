package fr.uge.bike.interf;

import fr.uge.bike.data.Bike;
import fr.uge.bike.data.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IRentalBikes extends Remote {
    void addBike(User user, Bike bike) throws  RemoteException;
    User rentBike(User user, Bike bike) throws RemoteException;
    void returnBike(Bike bike) throws RemoteException;
    List<Bike> getBikes() throws RemoteException;
}
