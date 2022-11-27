package fr.uge.bike;

import java.rmi.RemoteException;

public interface IObserver {
    public void notifyChange(int value) throws RemoteException;
}
