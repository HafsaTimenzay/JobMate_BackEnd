package com.example.JobMatee.service;

import com.example.JobMatee.dto.CandidateDTO;
import com.example.JobMatee.dto.CandidateSignupDTO;
import com.example.JobMatee.dto.RecruiterDTO;
import com.example.JobMatee.dto.RecruiterSignUpDTO;
import com.example.JobMatee.model.User;

public interface UserService {

    CandidateSignupDTO createCandidate(CandidateSignupDTO candidateSignUpDTO);
    RecruiterSignUpDTO createRecruiter(RecruiterSignUpDTO recruiterSignUpDTO);

//    String generateVerificationToken();
//    User registerUser(CandidateSignupDTO userSignupDTO);
//    void verifyUser(String token);
//    void sendVerificationEmail(String email);
//    void resetPassword(String email, String newPassword);
}


