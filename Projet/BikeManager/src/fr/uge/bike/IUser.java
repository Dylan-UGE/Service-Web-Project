package fr.uge.bike;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IUser extends Remote {
    public String getUsername() throws RemoteException;
    public String getEmail() throws RemoteException;
}
