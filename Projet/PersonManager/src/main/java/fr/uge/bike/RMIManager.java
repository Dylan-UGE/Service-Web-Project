package fr.uge.bike;

import fr.uge.bike.data.Bike;
import fr.uge.bike.data.Feedback;
import fr.uge.bike.data.User;
import fr.uge.bike.interf.IFeedbackManager;
import fr.uge.bike.interf.IRentalBikes;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class RMIManager {

    private final Registry registry = LocateRegistry.getRegistry(null);

    private final IRentalBikes rentalBikes = (IRentalBikes) registry.lookup("/RentalBikes");

    private final IFeedbackManager feedbackManager = (IFeedbackManager) registry.lookup("/FeedbackManager");

    public RMIManager() throws RemoteException, NotBoundException {}

    public void addBike(Bike bike) throws RemoteException {
        rentalBikes.addBike(bike);
    }

    public void rentBike(User user, Bike bike) throws RemoteException {
        rentalBikes.rentBike(user, bike);
    }

    public User returnBike(User user, Bike bike) throws RemoteException {
        return rentalBikes.returnBike(user, bike);
    }

    public List<Bike> getBikes() throws RemoteException {
        return rentalBikes.getBikes();
    }

    public List<Bike> rentedBikeOfUser(User user) throws RemoteException {
        return rentalBikes.rentedBikeOfUser(user);
    }

    public void addFeedback(Bike bike, Feedback feedback) throws RemoteException {
        feedbackManager.addFeedback(bike, feedback);
    }
}
