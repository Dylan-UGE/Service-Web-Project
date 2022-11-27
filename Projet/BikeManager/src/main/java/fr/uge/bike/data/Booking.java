package fr.uge.bike.data;

import fr.uge.bike.interf.IBike;
import fr.uge.bike.interf.IBooking;
import fr.uge.bike.interf.IUser;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.stream.Collectors;

public class Booking extends UnicastRemoteObject implements IBooking {
    private final Map<IBike, LinkedList<IUser>> bookingQueues = new HashMap<>();

    public Booking() throws RemoteException {
    }

    public Set<IBike> getAllBikes() throws RemoteException {
        return bookingQueues.keySet();
    }

    public Set<IBike> getBikeRentByUser(IUser user) throws RemoteException {
        return bookingQueues.entrySet().stream()
                .filter(iBikeLinkedListEntry -> iBikeLinkedListEntry.getValue().get(0).equals(user))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public void addBike(IBike bike) {
        bookingQueues.computeIfAbsent(bike, bike1 -> new LinkedList<>());
    }

    public void rent(IBike bike, IUser user) throws RemoteException{
        LinkedList<IUser> userLinkedList =
                bookingQueues.computeIfAbsent(bike, bike1 -> new LinkedList<>());

        userLinkedList.addLast(user);
    }

    public boolean isFree(IBike bike) throws RemoteException{
        return !Optional.ofNullable(bookingQueues.get(bike))
                .map(List::isEmpty)
                .orElseThrow();
    }

    public IUser freePlace(IBike bike) throws RemoteException{
        var listUser = bookingQueues.get(bike);

        if(listUser == null || listUser.isEmpty()){
            return null;
        }

        return listUser.removeFirst();
    }
}
