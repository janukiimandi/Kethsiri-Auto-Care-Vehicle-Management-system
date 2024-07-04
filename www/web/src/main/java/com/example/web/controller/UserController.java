package com.example.web.controller;

import com.example.web.models.User;
import com.example.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/students")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public String addUser(@RequestBody User user) {
        userService.saveUser(user);
        return "New Member is added.";
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok().body(updatedUser);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "User with ID " + id + " deleted successfully.";
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password) {
        User foundUser = userService.findByUsername(username);

        if (foundUser != null && foundUser.getPassword().equals(password)) {
            // Redirect to home page with user ID appended to the URL
            String redirectUrl = "/home?id=" + foundUser.getUser_ID();
            return new ModelAndView(new RedirectView(redirectUrl));
        } else {
            // Redirect to login page with an error message
            String redirectUrl = "/login?error=1";
            return new ModelAndView(new RedirectView(redirectUrl));
        }
    }



    @GetMapping("/membercount")
    public ResponseEntity<Integer> getMemberCount() {
        int memberCount = userService.getMemberCount();
        return ResponseEntity.ok(memberCount);
    }
}


