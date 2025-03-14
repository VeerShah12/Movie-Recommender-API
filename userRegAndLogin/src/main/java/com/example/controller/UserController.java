package com.example.controller;

import com.example.entity.UserEntity;
import com.example.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserEntity user) {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            return "Username already taken!";
        }

        user.setRole("USER"); // Default role is USER
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encrypt password

        if (user.getFavoriteGenres() == null || user.getFavoriteGenres().isEmpty()) {
            return "Please provide at least one favorite genre!";
        }

        userRepo.save(user);
        return "User registered successfully!";
    }

    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        return userRepo.findAll();
    }
}
