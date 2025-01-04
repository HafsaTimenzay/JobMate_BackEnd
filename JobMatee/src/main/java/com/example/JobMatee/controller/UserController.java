package com.example.JobMatee.controller;

import com.example.JobMatee.dto.UserSignupDTO;
import com.example.JobMatee.model.User;
import com.example.JobMatee.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("/signup")
//    public ResponseEntity<String> signup(@RequestBody UserSignupDTO userSignupDTO) {
//        userService.registerUser(userSignupDTO);
//        return ResponseEntity.ok("Registration successful! Please check your email for verification.");
//    }
@PostMapping("/signup")
public ResponseEntity<Map<String, String>> signup(@RequestBody UserSignupDTO userSignupDTO) {
    try {
        userService.registerUser(userSignupDTO);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Registration successful!");
        response.put("role", String.valueOf(userSignupDTO.getRole()));
        return ResponseEntity.ok(response);
    } catch (Exception e) {
        // Log the error for debugging
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("message", "Registration failed: " + e.getMessage()));
    }
}


    @GetMapping("/verify")
    public ResponseEntity<String> verifyUser(@RequestParam("token") String token) {
        userService.verifyUser(token);
        return ResponseEntity.ok("Email verified successfully!");
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam("email") String email) {
        userService.sendVerificationEmail(email);
        return ResponseEntity.ok("Password reset email sent!");
    }
}
