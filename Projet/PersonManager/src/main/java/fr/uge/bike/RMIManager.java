package fr.uge.bike;

import fr.uge.bike.interf.IBike;
import fr.uge.bike.interf.IRentalBikes;
import fr.uge.bike.interf.IUser;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class RMIManager {
    private final Registry registry = LocateRegistry.getRegistry(null);

    private final IRentalBikes rentalBikes = (IRentalBikes) registry.lookup("/BikeService");

    public RMIManager() throws RemoteException, NotBoundException {
    }

    public void addBike(IUser user, String brand, String color, int size) throws RemoteException {
        rentalBikes.addBike(user, brand, color, size);
    }

    public void rentBike(IUser user, IBike bike) throws RemoteException {
        rentalBikes.rentBike(user, bike);
    }

    public void returnBike(IBike bike) throws RemoteException {
        rentalBikes.returnBike(bike);
    }

    public List<IBike> getBikes() throws RemoteException {
        return rentalBikes.getBikes();
    }
}
