package fr.uge.bike.controller;

import fr.uge.bike.data.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.rmi.RemoteException;

@Controller
@RequestMapping("/personmanager")
public class PersonController {

    @GetMapping
    public String userForm() {
        return "user-form";
    }

    @GetMapping("/select")
    public String postUser(@ModelAttribute("user") User user,
                           HttpSession session) throws RemoteException {
        session.setAttribute("user", user);

        return "user-select";
    }
}
