package com.example.JobMatee.service;

import com.example.JobMatee.dto.CandidateDTO;
import com.example.JobMatee.dto.CandidateSignupDTO;
import com.example.JobMatee.dto.RecruiterDTO;
import com.example.JobMatee.dto.RecruiterSignUpDTO;
import com.example.JobMatee.model.Candidate;
import com.example.JobMatee.model.Recruiter;
import com.example.JobMatee.model.Role;
import com.example.JobMatee.model.User;
import com.example.JobMatee.repository.CandidateRepository;
import com.example.JobMatee.repository.RecruiterRepository;
import com.example.JobMatee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CandidateRepository candidateRepository;
    private final PasswordEncoder passwordEncoder;  // Secure password storage
    private final RecruiterRepository recruiterRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           CandidateRepository candidateRepository,
                           PasswordEncoder passwordEncoder, RecruiterRepository recruiterRepository) {
        this.userRepository = userRepository;
        this.candidateRepository = candidateRepository;
        this.passwordEncoder = passwordEncoder;
        this.recruiterRepository = recruiterRepository;
    }

    @Override
    public CandidateSignupDTO createCandidate(CandidateSignupDTO createDTO) {
        // Create user base with role
        User user = new User();
        user.setEmail(createDTO.getEmail());
        user.setPassword(passwordEncoder.encode(createDTO.getPassword()));  // Use hashed password
        user.setRole(Role.CANDIDATE);
        user = userRepository.save(user);

        // Create candidate profile
        Candidate candidate = new Candidate();
        candidate.setFirstname(createDTO.getFirstname());
        candidate.setLastname(createDTO.getLastname());
        candidate.setId(user.getId());
        candidateRepository.save(candidate);

        // Manually map fields to DTO
        CandidateSignupDTO candidateSignUpDTO = new CandidateSignupDTO();
        candidateSignUpDTO.setEmail(user.getEmail());
        candidateSignUpDTO.setPassword(passwordEncoder.encode(user.getPassword()));
        candidateSignUpDTO.setRole(user.getRole());
        candidateSignUpDTO.setFirstname(candidate.getFirstname());
        candidateSignUpDTO.setLastname(candidate.getLastname());
        return candidateSignUpDTO;
    }

    @Override
    public RecruiterSignUpDTO createRecruiter(RecruiterSignUpDTO createDTO) {
        // Create and save User entity for Recruiter
        User user = new User();
        user.setEmail(createDTO.getEmail());
        user.setPassword(passwordEncoder.encode(createDTO.getPassword()));
        user.setRole(Role.RECRUITER);
        User savedUser = userRepository.save(user);

        // Create and associate Recruiter
        Recruiter recruiter = new Recruiter();
        recruiter.setId(savedUser.getId());  // Link Recruiter with User ID
        recruiter.setCompanyName(createDTO.getCompanyName());
        recruiter.setCompanyLogo(createDTO.getCompanyLogo());
        recruiter.setCompanyDescription(createDTO.getCompanyDescription());
        recruiter.setOrganisationType(createDTO.getOrganisationType());
        recruiter.setIndustryType(createDTO.getIndustryType());
        recruiter.setTeamSize(createDTO.getTeamSize());
        recruiter.setYearOfEstablishment(createDTO.getYearOfEstablishment());
        recruiter.setWebsiteUrl(createDTO.getWebsiteUrl());
        recruiter.setLinkedinUrl(createDTO.getLinkedinUrl());

        recruiterRepository.save(recruiter);

        // Map fields manually to DTO for response
        RecruiterSignUpDTO recruiterSignUpDTO = new RecruiterSignUpDTO();
        recruiterSignUpDTO.setEmail(savedUser.getEmail());
        recruiterSignUpDTO.setCompanyName(recruiter.getCompanyName());
        recruiterSignUpDTO.setCompanyLogo(recruiter.getCompanyLogo());
        recruiterSignUpDTO.setCompanyDescription(recruiter.getCompanyDescription());
        recruiterSignUpDTO.setOrganisationType(recruiter.getOrganisationType());
        recruiterSignUpDTO.setIndustryType(recruiter.getIndustryType());
        recruiterSignUpDTO.setTeamSize(recruiter.getTeamSize());
        recruiterSignUpDTO.setYearOfEstablishment(recruiter.getYearOfEstablishment());
        recruiterSignUpDTO.setWebsiteUrl(recruiter.getWebsiteUrl());
        recruiterSignUpDTO.setLinkedinUrl(recruiter.getLinkedinUrl());
        recruiterSignUpDTO.setRole(savedUser.getRole());

        return recruiterSignUpDTO;
    }


//    @Override
//    public RecruiterDTO createRecruiter(RecruiterSignUpDTO createDTO) {
//        // Similar implementation for Recruiter
//    }
}

//@Service
//public class UserServiceImpl implements UserService {

//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//    @Override
//    public String generateVerificationToken() {
//        return UUID.randomUUID().toString();
//    }
//
//    @Override
//    public User registerUser(CandidateSignupDTO userSignupDTO) {
//        // Check if email or username already exists
//        if (userRepository.existsByEmail(userSignupDTO.getEmail())) {
//            throw new RuntimeException("Email already in use");
//        }
//        // Create new user
//        User user = new User();
//        user.setFirstname(userSignupDTO.getFirstName());
//        user.setLastname(userSignupDTO.getLastName());
//        user.setEmail(userSignupDTO.getEmail());
//        user.setPassword(passwordEncoder.encode(userSignupDTO.getPassword()));
//        user.setRole(userSignupDTO.getRole());
//        user.setVerified(false); // Default to unverified
//
//        // Generate verification token
//        String token = generateVerificationToken();
//        user.setVerificationToken(token);
//
//        // Save user and send verification email
//        User savedUser = userRepository.save(user);
//        sendVerificationEmail(user.getEmail());
//
//        return savedUser;
//    }
//
//    @Override
//    public void verifyUser(String token) {
//        // Fetch the user based on the token
//        User user = userRepository.findByVerificationToken(token)
//                .orElseThrow(() -> new RuntimeException("Invalid or expired token"));
//
//        // Mark the user as verified
//        user.setVerified(true);
//        user.setVerificationToken(null); // Clear the token after verification
//        userRepository.save(user);
//    }
//
//
//    @Override
//    public void sendVerificationEmail(String email) {
//        // Fetch the user by email
//        User user = userRepository.findByEmail(email)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        if (user.isVerified()) {
//            throw new RuntimeException("User is already verified.");
//        }
//
//        // Generate a token if it doesn't exist
//        if (user.getVerificationToken() == null) {
//            user.setVerificationToken(generateVerificationToken());
//            userRepository.save(user);
//        }
//
//        // Compose the verification link
//        String verificationLink = "http://localhost:8080/api/users/verify?token=" + user.getVerificationToken();
//
//        // Send the email (you can use a library like JavaMailSender)
//        String subject = "Verify your account";
//        String body = "Click the link to verify your account: " + verificationLink;
//
//        EmailSender.sendEmail(user.getEmail(), subject, body);
//    }
//
//
//    @Override
//    public void resetPassword(String email, String newPassword) {
//        User user = userRepository.findByEmail(email)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        user.setPassword(passwordEncoder.encode(newPassword));
//        userRepository.save(user);
//    }
//}

