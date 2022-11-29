package fr.uge.bike.data;


import fr.uge.bike.interf.IRentalBikes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RentalBikeManager extends UnicastRemoteObject implements IRentalBikes {
    private final Booking booking = new Booking();
    private final Observable observable = new Observable();
    private int id = 0;

    public RentalBikeManager() throws RemoteException {
        booking.addBike(new Bike(id++, "Decathlon", "red", 70));
        booking.addBike(new Bike(id++, "Btwin", "black", 50));
        addObservable(new Observer());
    }

    public void addObservable(Observer obs) throws RemoteException {
        observable.subscribe(obs);
    }

    public void addBike(User user, Bike bike) throws RemoteException {
        bike.setId(id++);
        booking.addBike(bike);
    }

    public List<Bike> getBikes() throws RemoteException {
        return booking.getAllBikes();
    }

    public boolean isFree(Bike bike) throws RemoteException {
        return booking.isFree(bike);
    }

    public void rentBike(User user, Bike bike) throws RemoteException {
        if(booking.rent(bike, user)){
            observable.newRent(user);
        };
    }

    public void returnBike(Bike bike) throws RemoteException {
        User renter = booking.freePlace(bike);
        observable.newRent(renter);
    }
}
