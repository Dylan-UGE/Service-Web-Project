package fr.uge.bike.data;


import fr.uge.bike.interf.IRentalBikes;
import fr.uge.bike.interf.IUser;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RentalBikeManager extends UnicastRemoteObject implements IRentalBikes {
    private final Booking booking = new Booking();
    private int id = 0;

    public RentalBikeManager() throws RemoteException {
        booking.addBike(new Bike(id++, "Decathlon", "red", 70));
        booking.addBike(new Bike(id++, "Btwin", "black", 50));
    }

    public void addBike(IUser user, String brand, String color, int size) throws RemoteException {
        booking.addBike(new Bike(id++, brand, color, size));
    }

    public List<Bike> getBikes() throws RemoteException {
        return booking.getAllBikes();
    }

    public boolean isFree(Bike bike) throws RemoteException {
        return booking.isFree(bike);
    }

    public void rentBike(IUser user, Bike bike) throws RemoteException {
        booking.rent(bike, user);
    }

    public void returnBike(Bike bike) throws RemoteException {
        booking.freePlace(bike);
    }
}
