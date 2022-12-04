package bike;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;

import fr.uge.bike.data.Bike;
import fr.uge.bike.data.User;
import fr.uge.bike.interf.IBuyBike;

public class GetBike {
	private final Registry registry;
	private final IBuyBike rentalBikes;
	
	public GetBike() throws RemoteException, NotBoundException{
		registry = LocateRegistry.getRegistry(null);
		rentalBikes = (IBuyBike) registry.lookup("/BuyBike");
		System.out.println("Allo");
	}
	
	public Bike[] getBike() throws RemoteException {
		return rentalBikes.getBikes();
	}
	
	public boolean buyBikes(User user, Bike[] lst) throws RemoteException {
		rentalBikes.buyBike(user, Arrays.stream(lst).toList());
		return true; // Faire la banque 
	}
}
