package com.example.JobMatee.service;

import com.example.JobMatee.dto.CandidateDTO;
import com.example.JobMatee.dto.CandidateSignupDTO;
import com.example.JobMatee.model.*;
import com.example.JobMatee.repository.*;
import com.example.JobMatee.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;
    private final UserRepository userRepository;

    public CandidateService(CandidateRepository candidateRepository, UserRepository userRepository) {
        this.candidateRepository = candidateRepository;
        this.userRepository = userRepository;
    }

    public Candidate updateCandidate(Long id, Candidate updatedCandidate) {
        // Find the candidate by ID
        Optional<Candidate> candidateOptional = candidateRepository.findById(id);

        if (candidateOptional.isPresent()) {
            Candidate existingCandidate = candidateOptional.get();

            // Update the fields that can be updated
            existingCandidate.setFirstname(updatedCandidate.getFirstname());
            existingCandidate.setLastname(updatedCandidate.getLastname());
            existingCandidate.setDateOfBirth(updatedCandidate.getDateOfBirth());
            existingCandidate.setGender(updatedCandidate.getGender());
            existingCandidate.setCity(updatedCandidate.getCity());
            existingCandidate.setPhoneNumber(updatedCandidate.getPhoneNumber());
            existingCandidate.setProfilePicture(updatedCandidate.getProfilePicture());
            existingCandidate.setResumePath(updatedCandidate.getResumePath());
            existingCandidate.setJobTitle(updatedCandidate.getJobTitle());
            existingCandidate.setEducationLevel(updatedCandidate.getEducationLevel());
            existingCandidate.setExperienceYears(updatedCandidate.getExperienceYears());
            existingCandidate.setBio(updatedCandidate.getBio());
            existingCandidate.setPersonalWebsite(updatedCandidate.getPersonalWebsite());
            existingCandidate.setLinkedinUrl(updatedCandidate.getLinkedinUrl());

            // Save the updated candidate
            return candidateRepository.save(existingCandidate);
        } else {
            throw new RuntimeException("Candidate not found with id " + id);
        }
    }

    @Autowired
    public CandidateService(UserRepository userRepository, CandidateRepository candidateRepository) {
        this.userRepository = userRepository;
        this.candidateRepository = candidateRepository;
    }

    public Candidate findCandidateByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        if (user.getRole() != Role.CANDIDATE) {
            throw new IllegalArgumentException("User is not a candidate");
        }
        return candidateRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("Candidate not found with user ID: " + user.getId()));
    }

    public List<JobApplication> getApplicationsByEmail(String email) {
        // Find the candidate by email
        Candidate candidate = findCandidateByEmail(email);

        // Get the applications related to the candidate
        return candidate.getApplications();
    }



//    public Candidate getCandidateByUserEmail(String email) {
//        User user = userRepository.findByEmail(email).orElse(null);
//        if (user == null) {
//            return null;  // Handle case if user is not found
//        }
//        return candidateRepository.findById(user.getId()).orElse(null);
//    }



//    @Autowired
//    private CandidateRepository candidateRepository;
//
//    @Autowired
//    private JobApplicationRepository jobApplicationRepository;
//
//    @Autowired
//    private CandidateRepository CandidateRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private JobRepository jobRepository;
//
//
//    public List<JobApplication> getAllApplications(Long candidateId) {
//        return jobApplicationRepository.findByCandidateId(candidateId);
//    }


//    public CandidateDTO createCandidate(CandidateSignupDTO signUpDTO) {
//        User user = new User(signUpDTO.getEmail(), signUpDTO.getPassword(), Role.CANDIDATE);
//        Candidate candidate = new Candidate();
//        candidate.setFirstname(signUpDTO.getFirstName());
//        candidate.setLastname(signUpDTO.getLastName());
//        candidate.setUser(user);
//        // Save user and candidate to the database
//        Candidate savedCandidate = candidateRepository.save(candidate);
//        return candidateMapper.toDTO(savedCandidate);  // Map to DTO
//    }


//    public void applyToJob(Long candidateId, Long jobId, String resumePath, String additionalNotes) {
//        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(() -> new RuntimeException("Candidate not found"));
//        Job job = jobRepository.findById(jobId).orElseThrow(() -> new RuntimeException("Job not found"));
//
//        JobApplication application = new JobApplication();
//        application.setCandidate(candidate);
//        application.setJob(job);
//        application.setResumePath(resumePath);
//        application.setAdditionalNotes(additionalNotes);
//        application.setAppliedDate(LocalDate.now());
////        application.setStatus(true);
//
//        jobApplicationRepository.save(application);
//    }

//    public void updateEmail(Long candidateId, String newEmail) {
//        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(() -> new RuntimeException("Candidate not found"));
//        candidate.setEmail(newEmail); // Assuming `email` is in `Candidate` or `User` superclass
//        candidateRepository.save(candidate);
//    }
//
//    public void updatePassword(Long candidateId, String newPassword) {
//        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(() -> new RuntimeException("Candidate not found"));
//        String encodedPassword = passwordEncoder.encode(newPassword); // Assuming PasswordEncoder is used
//        candidate.setPassword(encodedPassword);
//        candidateRepository.save(candidate);
//    }
//    public void updateProfilePicture(Long candidateId, String path) {
//        Candidate settings = CandidateRepository.findByCandidateId(candidateId);
//        if (settings == null) {
//            throw new RuntimeException("Candidate settings not found for id: " + candidateId);
//        }
//        settings.setProfilePicture(path); // Update the profile picture path
//        CandidateRepository.save(settings); // Save the changes
//    }

//    public Candidate getCandidateById(Long id) {
//        return candidateRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Candidate not found"));
//    }
}

