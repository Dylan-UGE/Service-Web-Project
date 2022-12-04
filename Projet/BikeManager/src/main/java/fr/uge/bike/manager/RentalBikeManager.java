package fr.uge.bike.manager;


import fr.uge.bike.data.*;
import fr.uge.bike.interf.IRentalBikes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.stream.Collectors;

public class RentalBikeManager extends UnicastRemoteObject implements IRentalBikes {
    private final LinkedHashMap<Bike, LinkedList<User>> bookingQueues = new LinkedHashMap<>();
    private int id = 0;

    public RentalBikeManager() throws RemoteException {
        addBike(new Bike("Decathlon", "red", 70));
        addBike(new Bike("Btwin", "black", 50));
    }

    public boolean addBike(Bike bike) throws RemoteException {
        bike.setId(id++);
        bookingQueues.computeIfAbsent(bike, bike1 -> new LinkedList<>());

        System.out.println("New bike to rent : " + bike);
        return bookingQueues.containsKey(bike);
    }

    public List<Bike> getBikes() throws RemoteException {
        return new ArrayList<>(bookingQueues.keySet());
    }

    public Boolean rentBike(User user, Bike bike) throws RemoteException {
        LinkedList<User> userLinkedList = bookingQueues.computeIfAbsent(bike, bike1 -> new LinkedList<>());

        if(userLinkedList.contains(user)) {
            return null;
        }

        userLinkedList.add(user);
        boolean rented = bookingQueues.get(bike).size() == 1;

        if(rented) {
            System.out.println("(" + user + ") " + " rent the bike " + bike);
        }
        else {
            System.out.println("(" + user + ") " + " added to the booking queue of bike " + bike);
        }

        return rented;
    }

    public User returnBike(User user, Bike bike) throws RemoteException {
        var listUser = bookingQueues.get(bike);

        if(listUser == null || listUser.isEmpty()){
            return null;
        }

        System.out.println("(" + user + ") " + " return the bike " + bike);
        listUser.removeFirst();
        if(listUser == null || listUser.isEmpty()){
            return null;
        }
        User newRenter = listUser.getFirst();
        System.out.println(newRenter+" rent the bike "+ bike);
        return newRenter;
    }

    public List<Bike> rentedBikeOfUser(User user) throws RemoteException {
        return bookingQueues.entrySet().stream()
                .filter(bikeLinkedListEntry -> {
                    LinkedList<User> userLinkedList = bikeLinkedListEntry.getValue();
                    return !userLinkedList.isEmpty() && userLinkedList.element().equals(user);
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public boolean deleteBike(User user, Bike bike) {
        bookingQueues.remove(bike);
        System.out.println("The bike " + bike + " have be buy by " + user);
        return true;
    }
}
