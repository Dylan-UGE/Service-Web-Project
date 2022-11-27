package fr.uge.bike;

import java.rmi.RemoteException;

public interface IObserve {
    public void subscribe(IObservateur obs) throws RemoteException;
}
