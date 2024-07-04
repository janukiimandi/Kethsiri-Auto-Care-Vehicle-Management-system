package com.example.web.controller;

import com.example.web.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/contact")
    public ResponseEntity<String> sendMessage(@RequestParam String name,
                                              @RequestParam String email,
                                              @RequestParam String subject,
                                              @RequestParam String message) {
        String to = "your@email.com"; // Specify your email address here
        String body = "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Subject: " + subject + "\n" +
                "Message: " + message;

        emailSenderService.sendEmail(to, subject, body);

        return ResponseEntity.ok("Message sent successfully.");
    }
}
