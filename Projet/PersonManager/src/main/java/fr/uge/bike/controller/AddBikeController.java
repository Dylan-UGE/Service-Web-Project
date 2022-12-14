package fr.uge.bike.controller;

import fr.uge.bike.RMIManager;
import fr.uge.bike.data.Bike;
import fr.uge.bike.data.User;
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
@RequestMapping("/addbike")
public class AddBikeController {

    private final RMIManager rmiManager;

    public AddBikeController(RMIManager rmiManager) {
        this.rmiManager = Objects.requireNonNull(rmiManager);
    }

    @GetMapping
    public String rentForm(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/personmanager";
        }

        return "add-bike-form";
    }

    @PostMapping
    public String rentBike(@ModelAttribute("bike") Bike bike, Model model) throws RemoteException {
        model.addAttribute("bike", bike);
        rmiManager.addBike(bike);
        return "add-bike-post";
    }
}
