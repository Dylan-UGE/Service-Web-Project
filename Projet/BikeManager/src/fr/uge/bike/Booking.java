package fr.uge.bike;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class Booking extends UnicastRemoteObject implements IBooking{
    private final Map<IBike, LinkedList<IUser>> bookingQueues = new HashMap<>();

    public Booking() throws RemoteException {
    }

    public Set<IBike> getAllBikes() throws RemoteException {
        return bookingQueues.keySet();
    }

    public IUser rent(IBike bike, IUser user) throws RemoteException{
        LinkedList<IUser> userLinkedList =
                bookingQueues.computeIfAbsent(bike, bike1 -> new LinkedList<>());

        userLinkedList.addLast(user);
        return userLinkedList.getFirst();
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
