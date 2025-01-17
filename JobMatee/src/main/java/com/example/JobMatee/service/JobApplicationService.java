package com.example.JobMatee.service;

import com.example.JobMatee.model.*;
import com.example.JobMatee.repository.CandidateRepository;
import com.example.JobMatee.repository.JobApplicationRepository;
import com.example.JobMatee.repository.JobRepository;
import com.example.JobMatee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobRepository jobRepository;
    public Candidate findCandidateByEmail(String email) {
        // Find the user by email to get the user ID
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Check if the user is a recruiter
        if (user.getRole() != Role.CANDIDATE) {
            throw new IllegalArgumentException("User is not a candidate");
        }

        // Find and return the recruiter by user ID
        return candidateRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("Candidate not found with user ID: " + user.getId()));
    }



    public JobApplication saveApplication(JobApplication application) {
        // Fetch the Candidate entity
        Candidate candidate = candidateRepository.findById(application.getCandidate().getId())
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        // Fetch the Job entity
        Job job = jobRepository.findById(application.getJob().getId())
                .orElseThrow(() -> new RuntimeException("Job not found"));

        // Set the fetched entities
        application.setCandidate(candidate);
        application.setJob(job);

        // Save the JobApplication
        return jobApplicationRepository.save(application);
    }

    public List<JobApplication> getApplicationsByCandidate(Long candidateId) {
        return jobApplicationRepository.findByCandidateId(candidateId);
    }
}

