package fr.uge.bike.controller;

import fr.uge.bike.RMIManager;
import fr.uge.bike.data.Bike;
import fr.uge.bike.data.Feedback;
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
@RequestMapping("/return")
public class ReturnController {

    private final RMIManager rmiManager;

    public ReturnController(RMIManager rmiManager) {
        this.rmiManager = Objects.requireNonNull(rmiManager);
    }

    @GetMapping
    public String returnForm(Model model, HttpSession session) throws RemoteException {
        model.addAttribute("bikelist", rmiManager.rentedBikeOfUser((User) session.getAttribute("user")));
        return "return-form";
    }

    @PostMapping
    public String returnPost(@ModelAttribute("bike") Bike bike,
                             @ModelAttribute("feedback") Feedback feedback,
                             HttpSession session) throws RemoteException {
        User user = rmiManager.returnBike(bike);
        feedback.setUser(user);
        rmiManager.addFeedback(bike, feedback);
        return "return-post";
    }
}
