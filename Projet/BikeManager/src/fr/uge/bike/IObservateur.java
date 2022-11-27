package fr.uge.bike;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IObservateur {
    public void notifyChange(int value) throws RemoteException;
}
