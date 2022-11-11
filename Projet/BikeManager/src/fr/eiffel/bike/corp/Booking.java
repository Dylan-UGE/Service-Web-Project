package fr.eiffel.bike.corp;

import java.util.*;

public class Booking {
    //map<id bike, queues>
    Map<Integer, LinkedList<User>> queues = new HashMap<>();

    public void rent(int id, User user){
        var listUser = queues.get(id);
        if (listUser == null){
            queues.put(id, new LinkedList<User>(List.of(user)));
        }
        else{
            listUser.offerLast(user);
        }

    }

    public boolean isFree(int id){
        var listUser = queues.get(id);
        if(listUser == null || listUser.isEmpty()){
            return false;
        }
        return true;
    }

    public User freePlace(int id){
        //return user for the observer else null
        var listUser = queues.get(id);
        if(listUser == null || listUser.isEmpty()){
            return null;
        }
        return listUser.removeFirst();
    }
}
