package fr.uge.bike.configuration;

import fr.uge.bike.RMIManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

@Configuration
public class RMIConfiguration {
    @Bean
    public RMIManager rmiManager() throws NotBoundException, RemoteException {
        return new RMIManager();
    }
}
