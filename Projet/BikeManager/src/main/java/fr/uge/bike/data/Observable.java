package fr.uge.bike.data;

import fr.uge.bike.interf.IObservable;
import fr.uge.bike.interf.IObserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Observable extends UnicastRemoteObject implements IObservable {
    private  final List<IObserver> observers = new ArrayList<>();

    protected Observable() throws RemoteException {
    }

    @Override
    public void subscribe(IObserver obs) throws RemoteException {
        observers.add(obs);
    }

    public void newRent(User user) {
                observers.forEach(obs -> {
                    try {
                        obs.notifyChange(user);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                });
    }
}
