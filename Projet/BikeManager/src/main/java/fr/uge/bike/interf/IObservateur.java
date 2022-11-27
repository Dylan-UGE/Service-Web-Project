package fr.uge.bike.interf;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IObservateur {
    public void notifyChange(int value) throws RemoteException;
}
