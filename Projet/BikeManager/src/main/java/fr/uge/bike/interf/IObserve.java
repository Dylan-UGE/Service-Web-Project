package fr.uge.bike.interf;

import java.rmi.RemoteException;

public interface IObserve {
    public void subscribe(IObservateur obs) throws RemoteException;
}
