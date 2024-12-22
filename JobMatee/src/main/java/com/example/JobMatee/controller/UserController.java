package com.example.JobMatee.controller;

import com.example.JobMatee.dto.UserSignupDTO;
import com.example.JobMatee.model.User;
import com.example.JobMatee.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserSignupDTO userSignupDTO) {
        userService.registerUser(userSignupDTO);
        return ResponseEntity.ok("Registration successful! Please check your email for verification.");
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
