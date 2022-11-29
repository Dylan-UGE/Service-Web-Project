package fr.uge.bike;

import fr.uge.bike.manager.FeedbackManager;
import fr.uge.bike.manager.RentalBikeManager;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Application {
    public static void main(String[] args) throws IOException {
        try{
            System.out.println("Start Server");
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("/RentalBikes", new RentalBikeManager());
            registry.rebind("/FeedbackManager", new FeedbackManager());
        }catch (Exception e){
            throw  new IOException(e);
        }
    }
}
