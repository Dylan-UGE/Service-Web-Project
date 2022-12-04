package fr.uge.bike.manager;

import fr.uge.bike.data.Bike;
import fr.uge.bike.data.User;
import fr.uge.bike.interf.IBuyBike;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class BuyBikeManager extends UnicastRemoteObject implements IBuyBike {

    private final RentalBikeManager rtm;

    public BuyBikeManager(RentalBikeManager rtm) throws RemoteException {
        this.rtm = rtm;
    }

    @Override
    public Bike[] getBikes() throws RemoteException {
        var bikes = rtm.getBikes();
        Bike[] tmp = new Bike[bikes.size()];
        bikes.toArray(tmp);
        return tmp;
    }

    @Override
    public boolean buyBike(User user, List<Bike> bike) throws RemoteException {
        bike.forEach(e -> rtm.deleteBike(user, e));
        return true; // Voir pour Thread Safe
    }
}
