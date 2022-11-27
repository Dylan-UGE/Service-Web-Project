package fr.uge.bike;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class User extends UnicastRemoteObject implements IUser {
    private final String username;
    private final String email;

    public User(String username, String email) throws RemoteException {
        super();
        this.username = username;
        this.email = email;
    }

    public String getUsername() throws RemoteException{
        return username;
    }

    public String getEmail() throws RemoteException {
        return email;
    }

    @Override
    public String toString() {
        return username + " : " + email;
    }
}
