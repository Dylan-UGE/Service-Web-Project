package fr.uge.bike.interf;

import fr.uge.bike.data.Bike;
import fr.uge.bike.data.Feedback;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IFeedbackManager extends Remote {
    boolean addFeedback(Bike bike, Feedback feedback) throws RemoteException;
    List<Feedback> getFeedbacksOfBike(Bike bike) throws RemoteException;
}
