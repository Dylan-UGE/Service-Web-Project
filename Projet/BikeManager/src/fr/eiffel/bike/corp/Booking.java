package fr.eiffel.bike.corp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class Booking extends UnicastRemoteObject implements IBooking{
    //map<id bike, queues>
    Map<Integer, LinkedList<User>> queues;

    protected Booking() throws RemoteException {
        super();
        queues = new HashMap<>();
    }

    public void rent(int id, User user) throws RemoteException{
        var listUser = queues.get(id);
        if (listUser == null){
            queues.put(id, new LinkedList<User>(List.of(user)));
        }
        else{
            listUser.offerLast(user);
        }

    }

    public boolean isFree(int id) throws RemoteException{
        var listUser = queues.get(id);
        if(listUser == null || listUser.isEmpty()){
            return false;
        }
        return true;
    }

    public User freePlace(int id) throws RemoteException{
        //return user for the observer else null
        var listUser = queues.get(id);
        if(listUser == null || listUser.isEmpty()){
            return null;
        }
        return listUser.removeFirst();
    }
}
