package com.example.web.service;

import com.example.web.exception.ResourceNotFoundException;
import com.example.web.models.User;
import com.example.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User saveUser(User user) {
        return userRepository.save(user);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }


    public User updateUser(int id, User user) {
        if (userRepository.existsById(id)) {
            user.setUser_ID(id);
            return userRepository.save(user);
        } else {
            throw new ResourceNotFoundException("User with ID " + id + " not found.");
        }
    }


    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }


    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public int getMemberCount() {
        return userRepository.getMemberCount();
    }
}
