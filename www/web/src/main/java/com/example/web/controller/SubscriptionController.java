package com.example.web.controller;

import com.example.web.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SubscriptionController {

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/subscribe")
    public String subscribe(@RequestParam("email") String email) {
        // Call the email service to send the subscription email
        emailSenderService.sendEmail(email, "Thank you for subscribing!", "You have successfully subscribed to our newsletter.");
        return "redirect:/"; // Redirect to the homepage or any other page after submission
    }
}
