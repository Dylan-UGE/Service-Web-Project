package fr.uge.bike.data;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.stream.Collectors;

public class Booking extends UnicastRemoteObject {
    private final Map<Bike, LinkedList<User>> bookingQueues = new HashMap<>();

    public Booking() throws RemoteException {
    }

    public List<Bike> getAllBikes() throws RemoteException {
        return new ArrayList<>(bookingQueues.keySet());
    }

    public Set<Bike> rentBikesOfUser(User user) throws RemoteException {
        return bookingQueues.entrySet().stream()
                .filter(iBikeLinkedListEntry -> iBikeLinkedListEntry.getValue().getFirst().equals(user))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public void addBike(Bike bike) {
        bookingQueues.computeIfAbsent(bike, bike1 -> new LinkedList<>());
    }

    public boolean rent(Bike bike, User user) throws RemoteException {
        LinkedList<User> userLinkedList =
                bookingQueues.computeIfAbsent(bike, bike1 -> new LinkedList<>());

        userLinkedList.addLast(user);

        if (userLinkedList.getFirst().equals(user)) {
            return true;
        }
        return false;
    }

    public boolean isFree(Bike bike) throws RemoteException{
        return !Optional.ofNullable(bookingQueues.get(bike))
                .map(List::isEmpty)
                .orElseThrow();
    }

    public User freePlace(Bike bike) throws RemoteException{
        var listUser = bookingQueues.get(bike);

        if(listUser == null || listUser.isEmpty()){
            return null;
        }

        return listUser.removeFirst();
    }
}
