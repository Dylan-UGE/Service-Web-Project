package fr.uge.bike.interf;

import fr.uge.bike.data.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IObservable extends Remote {
    public void subscribe(IObserver obs) throws RemoteException;
}
