package fr.uge.bike;

import fr.uge.bike.data.RentalBikeManager;
import fr.uge.bike.interf.IRentalBikes;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Application {
    public static void main(String[] args) throws IOException {
        try{
            Registry registry = LocateRegistry.createRegistry(1099);
            IRentalBikes rentalBikes = new RentalBikeManager();
            registry.bind("/BikeService", rentalBikes);
        }catch (Exception e){
            throw  new IOException(e);
        }
    }
}
