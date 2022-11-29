package fr.uge.bike.controller;

import fr.uge.bike.RMIManager;
import fr.uge.bike.data.Bike;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.rmi.RemoteException;
import java.util.Objects;

@Controller
@RequestMapping("/addbike")
public class AddBikeController {

    private final RMIManager rmiManager;

    public AddBikeController(RMIManager rmiManager) {
        this.rmiManager = Objects.requireNonNull(rmiManager);
    }

    @GetMapping
    public String rentForm() {
        return "add-bike-form";
    }

    @PostMapping
    public String rentBike(@ModelAttribute("bike") Bike bike) throws RemoteException {
        rmiManager.addBike(bike);

        return "add-bike-post";
    }
}
