package client;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import javax.xml.rpc.ServiceException;

import bike.GetBike;
import bike.GetBikeServiceLocator;
import fr.uge.bike.data.Bike;
import fr.uge.bike.data.User;

public class ClientStub {
	public static void main(String[] args) throws ServiceException, RemoteException {
		GetBike service = new GetBikeServiceLocator().getGetBike();
		List<Bike> lst = Arrays.asList(service.getBike());
		System.out.println();
		for(Bike elem : lst) {
			System.out.println(elem.getId() + " " + elem.getBrand());
		}
		Bike[] tmp = new Bike[lst.size()];
        lst.toArray(tmp);
		service.buyBikes(new User("Chapron","Loic"), tmp);
	}
}
