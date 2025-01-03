package com.example.JobMatee.service;

import com.example.JobMatee.dto.UserSignupDTO;
import com.example.JobMatee.model.User;
import com.example.JobMatee.model.Role;
import com.example.JobMatee.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public String generateVerificationToken() {
        return UUID.randomUUID().toString();
    }

    @Override
    public User registerUser(UserSignupDTO userSignupDTO) {
        // Check if email or username already exists
        if (userRepository.existsByEmail(userSignupDTO.getEmail())) {
            throw new RuntimeException("Email already in use");
        }
        if (userRepository.existsByUsername(userSignupDTO.getUsername())) {
            throw new RuntimeException("Username already in use");
        }
        // Create new user
        User user = new User();
        user.setFirstname(userSignupDTO.getFirstName());
        user.setLastname(userSignupDTO.getLastName());
        user.setEmail(userSignupDTO.getEmail());
        user.setUsername(userSignupDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userSignupDTO.getPassword()));
        user.setRole(Role.valueOf(userSignupDTO.getRole().toUpperCase()));
        user.setVerified(false); // Default to unverified

        // Generate verification token
        String token = generateVerificationToken();
        user.setVerificationToken(token);

        // Save user and send verification email
        User savedUser = userRepository.save(user);
        sendVerificationEmail(user.getEmail());

        return savedUser;
    }

    @Override
    public void verifyUser(String token) {
        // Fetch the user based on the token
        User user = userRepository.findByVerificationToken(token)
                .orElseThrow(() -> new RuntimeException("Invalid or expired token"));

        // Mark the user as verified
        user.setVerified(true);
        user.setVerificationToken(null); // Clear the token after verification
        userRepository.save(user);
    }


    @Override
    public void sendVerificationEmail(String email) {
        // Fetch the user by email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.isVerified()) {
            throw new RuntimeException("User is already verified.");
        }

        // Generate a token if it doesn't exist
        if (user.getVerificationToken() == null) {
            user.setVerificationToken(generateVerificationToken());
            userRepository.save(user);
        }

        // Compose the verification link
        String verificationLink = "http://localhost:8080/api/users/verify?token=" + user.getVerificationToken();

        // Send the email (you can use a library like JavaMailSender)
        String subject = "Verify your account";
        String body = "Click the link to verify your account: " + verificationLink;

        EmailSender.sendEmail(user.getEmail(), subject, body);
    }


    @Override
    public void resetPassword(String email, String newPassword) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }
}

