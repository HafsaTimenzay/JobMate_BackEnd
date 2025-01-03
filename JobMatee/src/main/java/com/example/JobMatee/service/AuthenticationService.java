package com.example.JobMatee.service;

import com.example.JobMatee.model.User;
import com.example.JobMatee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // To compare hashed passwords

    public boolean authenticateUser(String email, String password) {
        // Find user by email
        Optional<User> optionalUser = userRepository.findByEmail(email);

        // Validate if user exists and password matches
        if (optionalUser.isPresent()) {
            User user = optionalUser.get(); // Extract the User object
            return passwordEncoder.matches(password, user.getPassword()); // Compare provided password with stored hashed password
        }

        return false; // Return false if user not found
    }
}


