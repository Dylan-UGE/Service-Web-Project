package fr.uge.bike.controller;

import fr.uge.bike.RMIManager;
import fr.uge.bike.data.Bike;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.rmi.RemoteException;
import java.util.Objects;

@Controller
@RequestMapping("/rental")
public class RentController {

    private final RMIManager rmiManager;

    public RentController(RMIManager rmiManager) {
        this.rmiManager = Objects.requireNonNull(rmiManager);
    }

    @GetMapping
    public String rentForm(Model model) throws RemoteException {
        model.addAttribute("bikelist", rmiManager.getBikes());
        return "rent-form";
    }

    @PostMapping
    public String rentBike(@ModelAttribute("bike") Bike bike, HttpSession session) throws RemoteException {

        return "rent-form";
    }
}
