package fr.uge.bike.interf;

import fr.uge.bike.data.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IObserver extends Remote {
    public void notifyChange(User user)throws RemoteException;
}
