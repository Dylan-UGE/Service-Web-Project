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
import java.util.Map;
import java.util.stream.Collectors;

public class RMIManager {

    private final Registry registry = LocateRegistry.getRegistry(null);

    private final IRentalBikes rentalBikes = (IRentalBikes) registry.lookup("/RentalBikes");

    private final IFeedbackManager feedbackManager = (IFeedbackManager) registry.lookup("/FeedbackManager");

    public RMIManager() throws RemoteException, NotBoundException {}

    public void addBike(Bike bike) throws RemoteException {
        rentalBikes.addBike(bike);
    }

    public Boolean rentBike(User user, Bike bike) throws RemoteException {
       return rentalBikes.rentBike(user, bike);
    }

    public User returnBike(User user, Bike bike) throws RemoteException {
        return rentalBikes.returnBike(user, bike);
    }

    public  Map<Integer, Bike> getBikes() throws RemoteException {
        return rentalBikes.getBikes().stream().collect(Collectors.toMap(Bike::getId, k -> k));
    }

    public Map<Integer, Bike> rentedBikeOfUser(User user) throws RemoteException {
        return rentalBikes.rentedBikeOfUser(user).stream().collect(Collectors.toMap(Bike::getId, k -> k));
    }

    public void addFeedback(Bike bike, Feedback feedback) throws RemoteException {
        feedbackManager.addFeedback(bike, feedback);
    }
}
