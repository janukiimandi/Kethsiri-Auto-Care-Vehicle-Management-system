package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homePage(@RequestParam("id") int userId, Model model) {
        // Here you can fetch additional data related to the user using the userId
        // For simplicity, we are just passing the userId to the view
        model.addAttribute("userId", userId);
        return "home"; // Assuming there is a view named "home.html" to be rendered
    }
}
