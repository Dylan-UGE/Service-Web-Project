package fr.uge.bike.controller;

import fr.uge.bike.data.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

@Controller
public class PersonController {

    @GetMapping("/personmanager")
    public String userForm(HttpSession session) {
        if(session.getAttribute("user") != null) {
            return "user-select";
        }

        return "user-form";
    }

    @GetMapping("/select")
    public String postUser(@ModelAttribute("user") User user, HttpSession session) {
        session.setAttribute("user", user);

        return "user-select";
    }
}
