package fr.eiffel.bike.corp.data;

import fr.eiffel.bike.corp.interf.IBooking;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class Booking extends UnicastRemoteObject implements IBooking {
    private final Map<Bike, LinkedList<User>> bookingQueues = new HashMap<>();

    public Booking() throws RemoteException {
        super();
    }

    public Set<Bike> getAllBikes() {
        return bookingQueues.keySet();
    }

    public void rent(Bike bike, User user) throws RemoteException{
        LinkedList<User> userLinkedList =
                bookingQueues.computeIfAbsent(bike, bike1 -> new LinkedList<>());

        userLinkedList.addLast(user);
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
