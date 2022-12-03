package fr.uge.bike.interf;

import fr.uge.bike.data.Bike;
import fr.uge.bike.data.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IBuyBike extends Remote{
	
	Bike[] getBikes() throws RemoteException;
	
	boolean buyBike(User user, List<Bike> bike) throws RemoteException;
}
