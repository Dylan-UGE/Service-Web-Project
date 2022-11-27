package fr.uge.bike.interf;

import java.rmi.RemoteException;

public interface IObservable {
    public void subscribe(IObserver obs) throws RemoteException;
}
