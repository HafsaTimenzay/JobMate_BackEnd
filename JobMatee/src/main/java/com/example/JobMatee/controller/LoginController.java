package com.example.JobMatee.controller;

import com.example.JobMatee.dto.LoginDTO;
import com.example.JobMatee.model.User;
import com.example.JobMatee.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
//        try {
//            // Authenticate user
//            boolean isAuthenticated = authenticationService.authenticateUser(loginDTO.getEmail(), loginDTO.getPassword());
//
//            if (isAuthenticated) {
//                return ResponseEntity.ok("Login successful!");
//            } else {
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during login");
//        }
//    }
@PostMapping("/login")
public ResponseEntity<Map<String, String>> login(@RequestBody LoginDTO loginDTO) {
    try {
        boolean isAuthenticated = authenticationService.authenticateUser(loginDTO.getEmail(), loginDTO.getPassword());

        if (isAuthenticated) {
            User user = authenticationService.getUserByEmail(loginDTO.getEmail());
            String role = String.valueOf(user.getRole()); // Assuming "role" is a field in User
            String email = user.getEmail(); // Add this line to get the email

            Map<String, String> response = new HashMap<>();
            response.put("message", "Login successful!");
            response.put("role", role);
            response.put("email", email); // Include the email in the response

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid credentials"));
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", "An error occurred"));
    }
}
}

