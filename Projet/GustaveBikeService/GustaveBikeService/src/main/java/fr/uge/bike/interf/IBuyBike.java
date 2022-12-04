package fr.uge.bike.interf;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import fr.uge.bike.data.*;

public interface IBuyBike extends Remote{
	
	Bike[] getBikes() throws RemoteException;
	
	boolean buyBike(User user, List<Bike> bike) throws RemoteException;
}
