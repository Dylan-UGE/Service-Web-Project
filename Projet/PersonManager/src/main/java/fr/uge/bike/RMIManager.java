package fr.uge.bike;

import fr.uge.bike.data.Bike;
import fr.uge.bike.data.User;
import fr.uge.bike.interf.IRentalBikes;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.List;

public class RMIManager {

    private final IRentalBikes rentalBikes = (IRentalBikes) LocateRegistry.getRegistry(null)
            .lookup("/BikeService");

    public RMIManager() throws RemoteException, NotBoundException {
    }

    public void addBike(User user, Bike bike) throws RemoteException {
        rentalBikes.addBike(user, bike);
    }

    public void rentBike(User user, Bike bike) throws RemoteException {
        rentalBikes.rentBike(user, bike);
    }

    public void returnBike(Bike bike) throws RemoteException {
        rentalBikes.returnBike(bike);
    }

    public List<Bike> getBikes() throws RemoteException {
        return rentalBikes.getBikes();
    }
}
