package fr.uge.bike.controller;

import fr.uge.bike.RMIManager;
import fr.uge.bike.data.Bike;
import fr.uge.bike.data.Feedback;
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
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/return")
public class ReturnController {

    private final RMIManager rmiManager;

    private Bike bikeToReturn;

    public ReturnController(RMIManager rmiManager) {
        this.rmiManager = Objects.requireNonNull(rmiManager);
    }

    @GetMapping
    public String returnForm(Model model, HttpSession session) throws RemoteException {
        if (session.getAttribute("user") == null) {
            return "redirect:/personmanager";
        }

        model.addAttribute("bikelist", List.copyOf(rmiManager.rentedBikeOfUser((User) session.getAttribute("user")).values()));
        return "return-form";
    }

    @PostMapping
    public String returnPost(@ModelAttribute("integerThymeleafUtil") IntegerThymeleafUtil bikeId,
                             HttpSession session, Model model) throws RemoteException {
        User user = (User) session.getAttribute("user");

        bikeToReturn = rmiManager.rentedBikeOfUser(user).get(bikeId.getId());
        rmiManager.returnBike(user, bikeToReturn);
        model.addAttribute("bike", bikeToReturn);
        return "return-post";
    }

    @PostMapping("/feedback")
    public String feedbackPost(@ModelAttribute("feedback")Feedback feedback, HttpSession session) throws RemoteException {
        if (session.getAttribute("user") == null || bikeToReturn == null) {
            return "redirect:/personmanager";
        }

        feedback.setUser((User) session.getAttribute("user"));
        rmiManager.addFeedback(bikeToReturn, feedback);
        return "feedback-post";
    }
}
