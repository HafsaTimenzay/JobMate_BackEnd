package com.example.JobMatee.service;

import com.example.JobMatee.model.Candidate;
import com.example.JobMatee.model.Job;
import com.example.JobMatee.model.JobApplication;
import com.example.JobMatee.repository.CandidateRepository;
import com.example.JobMatee.repository.JobApplicationRepository;
import com.example.JobMatee.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

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

