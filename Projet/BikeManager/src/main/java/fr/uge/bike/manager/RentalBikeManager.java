package fr.uge.bike.manager;


import fr.uge.bike.data.*;
import fr.uge.bike.interf.IRentalBikes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.stream.Collectors;

public class RentalBikeManager extends UnicastRemoteObject implements IRentalBikes {
    private final Map<Bike, LinkedList<User>> bookingQueues = new HashMap<>();
    private int id = 0;

    public RentalBikeManager() throws RemoteException {
        addBike(new Bike(id++, "Decathlon", "red", 70));
        addBike(new Bike(id++, "Btwin", "black", 50));
    }

    public boolean addBike(Bike bike) throws RemoteException {
        bike.setId(id++);
        bookingQueues.computeIfAbsent(bike, bike1 -> new LinkedList<>());

        return bookingQueues.containsKey(bike);
    }

    public List<Bike> getBikes() throws RemoteException {
        return new ArrayList<>(bookingQueues.keySet());
    }

    public void rentBike(User user, Bike bike) throws RemoteException {
        bookingQueues.computeIfAbsent(bike, bike1 -> new LinkedList<>())
                .add(user);
    }

    public User returnBike(Bike bike) throws RemoteException {
        var listUser = bookingQueues.get(bike);

        if(listUser == null || listUser.isEmpty()){
            return null;
        }

        return listUser.removeFirst();
    }

    public Set<Bike> rentedBikeOfUser(User user) throws RemoteException {
        return bookingQueues.entrySet().stream()
                .filter(bikeLinkedListEntry -> {
                    LinkedList<User> userLinkedList = bikeLinkedListEntry.getValue();
                    return !userLinkedList.isEmpty() && userLinkedList.getFirst().equals(user);
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
}
