package com.example.JobMatee.controller;

import com.example.JobMatee.dto.CandidateDTO;
import com.example.JobMatee.dto.CandidateSignupDTO;
import com.example.JobMatee.dto.RecruiterDTO;
import com.example.JobMatee.dto.RecruiterSignUpDTO;
import com.example.JobMatee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup/candidate")
    public ResponseEntity<?> signUpCandidate(@RequestBody CandidateSignupDTO candidateSignupDTO) {
        userService.createCandidate(candidateSignupDTO);
        return ResponseEntity.ok("Candidate registered successfully.");
    }

    @PostMapping("/signup/recruiter")
    public ResponseEntity<?> signUpRecruiter(@RequestBody RecruiterSignUpDTO createDTO) {
        RecruiterSignUpDTO recruiterDTO = userService.createRecruiter(createDTO);
        return new ResponseEntity<>(recruiterDTO, HttpStatus.CREATED);
    }


//    @PostMapping("/signup/recruiter")
//    public ResponseEntity<RecruiterDTO> signUpRecruiter(@RequestBody RecruiterSignUpDTO createDTO) {
//        RecruiterDTO recruiterDTO = userService.createRecruiter(createDTO);
//        return new ResponseEntity<>(recruiterDTO, HttpStatus.CREATED);
//    }

}

//public class UserController {

//    private final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
////    @PostMapping("/signup")
////    public ResponseEntity<String> signup(@RequestBody UserSignupDTO userSignupDTO) {
////        userService.registerUser(userSignupDTO);
////        return ResponseEntity.ok("Registration successful! Please check your email for verification.");
////    }
//@PostMapping("/signup")
//public ResponseEntity<Map<String, String>> signup(@RequestBody CandidateSignupDTO userSignupDTO) {
//    try {
//        userService.registerUser(userSignupDTO);
//        Map<String, String> response = new HashMap<>();
//        response.put("message", "Registration successful!");
//        response.put("role", String.valueOf(userSignupDTO.getRole()));
//        return ResponseEntity.ok(response);
//    } catch (Exception e) {
//        // Log the error for debugging
//        e.printStackTrace();
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(Map.of("message", "Registration failed: " + e.getMessage()));
//    }
//}
//
//
//    @GetMapping("/verify")
//    public ResponseEntity<String> verifyUser(@RequestParam("token") String token) {
//        userService.verifyUser(token);
//        return ResponseEntity.ok("Email verified successfully!");
//    }
//
//    @PostMapping("/forgot-password")
//    public ResponseEntity<String> forgotPassword(@RequestParam("email") String email) {
//        userService.sendVerificationEmail(email);
//        return ResponseEntity.ok("Password reset email sent!");
//    }
//}
