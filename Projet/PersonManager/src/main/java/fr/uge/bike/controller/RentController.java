package fr.uge.bike.controller;

import fr.uge.bike.RMIManager;
import fr.uge.bike.data.Bike;
import fr.uge.bike.data.User;
import fr.uge.bike.utils.IntegerThymeleafUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/rental")
public class RentController {

    private final RMIManager rmiManager;

    private final List<Bike> bikeList;

    public RentController(RMIManager rmiManager) throws RemoteException {
        this.rmiManager = Objects.requireNonNull(rmiManager);
        this.bikeList = rmiManager.getBikes();
    }

    @GetMapping
    public String rentForm(Model model) {
        model.addAttribute("bikelist", bikeList);
        return "rent-form";
    }

    @PostMapping
    public String rentBike(@ModelAttribute("integerThymeleafUtil") IntegerThymeleafUtil bikeId,
                           HttpSession session, Model model) throws RemoteException {
        Bike bike = bikeList.get(bikeId.getId());
        model.addAttribute("bike", bike);
        rmiManager.rentBike((User) session.getAttribute("user"), bike);
        return "rent-post";
    }
}
