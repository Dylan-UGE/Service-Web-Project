package fr.uge.bike.data;

import fr.uge.bike.interf.IUser;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.stream.Collectors;

public class Booking extends UnicastRemoteObject {
    private final Map<Bike, LinkedList<IUser>> bookingQueues = new HashMap<>();

    public Booking() throws RemoteException {
    }

    public List<Bike> getAllBikes() throws RemoteException {
        return new ArrayList<>(bookingQueues.keySet());
    }

    public Set<Bike> getBikeRentByUser(IUser user) throws RemoteException {
        return bookingQueues.entrySet().stream()
                .filter(iBikeLinkedListEntry -> iBikeLinkedListEntry.getValue().get(0).equals(user))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public void addBike(Bike bike) {
        bookingQueues.computeIfAbsent(bike, bike1 -> new LinkedList<>());
    }

    public void rent(Bike bike, IUser user) throws RemoteException{
        LinkedList<IUser> userLinkedList =
                bookingQueues.computeIfAbsent(bike, bike1 -> new LinkedList<>());

        userLinkedList.addLast(user);
    }

    public boolean isFree(Bike bike) throws RemoteException{
        return !Optional.ofNullable(bookingQueues.get(bike))
                .map(List::isEmpty)
                .orElseThrow();
    }

    public IUser freePlace(Bike bike) throws RemoteException{
        var listUser = bookingQueues.get(bike);

        if(listUser == null || listUser.isEmpty()){
            return null;
        }

        return listUser.removeFirst();
    }
}
