package fr.uge.bike.data;

import fr.uge.bike.data.Bike;
import fr.uge.bike.data.Booking;
import fr.uge.bike.interf.IBike;
import fr.uge.bike.interf.IBooking;
import fr.uge.bike.interf.IRentalBikes;
import fr.uge.bike.interf.IUser;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RentalBikeManager extends UnicastRemoteObject implements IRentalBikes {
    private final IBooking booking = new Booking();
    private final List<IBike> bikes = new ArrayList<>();
    private int id = 0;

    public RentalBikeManager() throws RemoteException {
    }

    public void addBike(IUser user, String brand, String color, int size) throws RemoteException {
        bikes.add(new Bike(id, brand, color, size));
        id++;
    }

    public List<IBike> getBikes() throws RemoteException {
        return bikes;
    }

    public void rentBike(IUser user, IBike bike) throws RemoteException {
        booking.rent(bike, user);
    }

    public void returnBike(IBike bike) throws RemoteException {
        booking.freePlace(bike);
    }


}
