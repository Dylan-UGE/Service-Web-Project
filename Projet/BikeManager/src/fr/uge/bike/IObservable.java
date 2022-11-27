package fr.uge.bike;

import java.rmi.RemoteException;

public interface IObservable {
    public void subscribe(IObserver obs) throws RemoteException;
}
