package client;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import bike.GetBike;
import bike.GetBikeServiceLocator;
import fr.uge.bike.data.Bike;
import fr.uge.bike.data.User;

public class ClientStub {
	
	private Map<User, Integer> map = new HashMap<User, Integer>();
	
	public static void main(String[] args) throws ServiceException, RemoteException {
		GetBike service = new GetBikeServiceLocator().getGetBike();
		List<Bike> lst = Arrays.asList(service.getBike());
		for(Bike elem : lst) {
			System.out.println(elem.getId() + " " + elem.getBrand());
		}
		List<Bike> newlst = new ArrayList<Bike>();
		newlst.add(lst.get(0));
		Bike[] tmp = new Bike[newlst.size()];
		newlst.toArray(tmp);
		service.buyBikes(new User("Chapron","Loic"),80, tmp);
	}
}
