package fr.uge.bike.controller;

import fr.uge.bike.data.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {

    @GetMapping
    public String getUser() {
        return "user-form";
    }

    @PostMapping
    public String postUser(@ModelAttribute("rectangle") User user) {
        return "user-post";
    }
}
