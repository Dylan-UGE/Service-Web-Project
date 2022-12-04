package fr.uge.bike;

import fr.uge.bike.data.Bike;
import fr.uge.bike.manager.BuyBikeManager;
import fr.uge.bike.manager.FeedbackManager;
import fr.uge.bike.manager.RentalBikeManager;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
        try{
            System.out.println("Start Server");

            Registry registry = LocateRegistry.createRegistry(1099);
            RentalBikeManager rentalBikeManager = new RentalBikeManager();

            registry.rebind("/RentalBikes", rentalBikeManager);
            registry.rebind("/FeedbackManager", new FeedbackManager());
            registry.rebind("/BuyBike", new BuyBikeManager(rentalBikeManager));

            try(Scanner scanner = new Scanner(System.in)) {
                System.out.println("Just write ADDBIKE for add bike to rent");

                while (scanner.hasNext()) {
                    if(scanner.nextLine().equals("ADDBIKE")) {
                        System.out.print("Brand of the Bike : ");
                        String brand = scanner.nextLine();
                        System.out.print("Color of the Bike : ");
                        String color = scanner.nextLine();
                        System.out.print("Size of the Bike : ");
                        int size = scanner.nextInt();

                        rentalBikeManager.addBike(new Bike(brand, color, size));
                    }
                }

            }
        }catch (Exception e){
            throw  new IOException(e);
        }
    }
}
