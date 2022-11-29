package fr.uge.bike.manager;

import fr.uge.bike.data.Bike;
import fr.uge.bike.data.Feedback;
import fr.uge.bike.interf.IFeedbackManager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class FeedbackManager extends UnicastRemoteObject implements IFeedbackManager {
    private final Map<Bike, List<Feedback>> bikeFeedbacks = new HashMap<>();

    public FeedbackManager() throws RemoteException {
        super();
    }

    public boolean addFeedback(Bike bike, Feedback feedback) throws RemoteException {
        List<Feedback> feedbackList =
                bikeFeedbacks.computeIfAbsent(bike, bike1 -> new ArrayList<>());

        feedbackList.add(feedback);
        return feedbackList.contains(feedback);
    }

    public List<Feedback> getFeedbacksOfBike(Bike bike) throws RemoteException {
        return bikeFeedbacks.getOrDefault(bike, Collections.emptyList());
    }
}
