package com.example.JobMatee.service;

import com.example.JobMatee.dto.UserSignupDTO;
import com.example.JobMatee.model.User;

public interface UserService {
    String generateVerificationToken();

    User registerUser(UserSignupDTO userSignupDTO);
    void verifyUser(String token);
    void sendVerificationEmail(String email);
    void resetPassword(String email, String newPassword);
}
