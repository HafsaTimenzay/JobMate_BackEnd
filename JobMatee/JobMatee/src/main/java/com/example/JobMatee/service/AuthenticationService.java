package com.example.JobMatee.service;

import com.example.JobMatee.model.User;
import com.example.JobMatee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // To compare hashed passwords

    public boolean authenticateUser(String email, String password) {
        // Find user by email
        User user = userRepository.findByEmail(email);

        // Check if user exists and password matches
        return user != null && passwordEncoder.matches(password, user.getPassword());
    }
}

