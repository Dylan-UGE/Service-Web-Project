package fr.uge.bike;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ApplicationRMI {
    public static void main(String[] args) throws RemoteException {
        try{
            System.out.println("begin");
            IUser user = new User("thomas", "pourchet@lol.fr");
            Registry registry = LocateRegistry.getRegistry(null);
            IRentalBikes rentalBikes = (IRentalBikes) registry.lookup("/BikeService");
            rentalBikes.addBike(user, "decat", "red", 70);
            rentalBikes.addBike(user, "btwin", "black", 50);
            rentalBikes.getBikes().forEach(b -> {
                try {
                    System.out.println(b.getBrand());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("end");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
