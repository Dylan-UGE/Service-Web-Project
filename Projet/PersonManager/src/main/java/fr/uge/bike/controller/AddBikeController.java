package fr.uge.bike.controller;

import fr.uge.bike.data.Bike;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.rmi.RemoteException;

@Controller
@RequestMapping("/addbike")
public class AddBikeController {

    @GetMapping
    public String rentForm() {
        return "add-bike-form";
    }

    @PostMapping
    public String rentBike(@ModelAttribute("bike") Bike bike, HttpSession session) {
        return "add-bike-form";
    }
}
