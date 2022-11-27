package fr.uge.bike;

import fr.uge.bike.data.User;
import fr.uge.bike.interf.IRentalBikes;
import fr.uge.bike.interf.IUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

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
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
