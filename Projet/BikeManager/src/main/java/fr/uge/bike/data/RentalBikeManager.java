package fr.uge.bike.data;


import fr.uge.bike.interf.IBike;
import fr.uge.bike.interf.IBooking;
import fr.uge.bike.interf.IRentalBikes;
import fr.uge.bike.interf.IUser;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RentalBikeManager extends UnicastRemoteObject implements IRentalBikes {
    private final Booking booking = new Booking();
    private int id = 0;

    public RentalBikeManager() throws RemoteException {}

    public void addBike(IUser user, String brand, String color, int size) throws RemoteException {
        booking.addBike(new Bike(id++, brand, color, size));
    }

    public Set<IBike> getBikes() throws RemoteException {
        return booking.getAllBikes();
    }

    public boolean isFree(IBike bike) throws RemoteException {
        return booking.isFree(bike);
    }

    public void rentBike(IUser user, IBike bike) throws RemoteException {
        booking.rent(bike, user);
    }

    public void returnBike(IBike bike) throws RemoteException {
        booking.freePlace(bike);
    }
}
