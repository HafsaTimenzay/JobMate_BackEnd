package com.example.JobMatee.service;

import com.example.JobMatee.model.*;
import com.example.JobMatee.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobService {
    private final JobRepository jobRepository;
    @Autowired
    private RecruiterRepository recruiterRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RecruiterService recruiterService;




    @Autowired
    public JobService(JobRepository jobRepository, CandidateRepository candidateRepository, RecruiterCandidateRepository recruiterCandidateRepository) {
        this.jobRepository = jobRepository;

    }

    // Créer un job
    public Job createJob(Job job) {
        job.setPostedDate(java.time.LocalDate.now());
        // Ajoutez des vérifications supplémentaires si nécessaire
        return jobRepository.save(job);
    }

    // Afficher tous les jobs
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    public Recruiter findRecruiterByEmail(String email) {
        // Find the user by email to get the user ID
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Check if the user is a recruiter
        if (user.getRole() != Role.RECRUITER) {
            throw new IllegalArgumentException("User is not a recruiter");
        }

        // Find and return the recruiter by user ID
        return recruiterRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("Recruiter not found with user ID: " + user.getId()));
    }
    public List<Job> getJobsByRecruiterEmail(String email) {
        // Find the recruiter by email
        Recruiter recruiter = recruiterService.findRecruiterByEmail(email);

        // Get all jobs posted by the recruiter
        return jobRepository.findByRecruiter(recruiter);  // Assuming you have a custom method in JobRepository
    }

    //
//    @Autowired
//    private JobRepository jobRepository;
//
//    public JobService(JobRepository jobRepository) {
//        this.jobRepository = jobRepository;
//    }
//
//    public List<Job> findJobsByTypeAndSubType(JobType type, JobSubType subType) {
//        return jobRepository.findByTypeAndSubType(type, subType);
//    }
//
//    /**
//     * Search and filter jobs based on criteria.
//     */
//    public List<Job> searchAndFilterJobs(String keyword, String location, String category, String type, Double minSalary, Double maxSalary, Boolean remote) {
//        return jobRepository.findByCriteria(keyword, location, category, type, minSalary, maxSalary, remote);
//    }
//
//    /**
//     * Fetch a job by its ID.
//     */
//    public Job getJobById(Long jobId) {
//        return jobRepository.findById(jobId)
//                .orElseThrow(() -> new RuntimeException("Job not found!"));
//    }
//
    public void applyToJob(Long jobId, Candidate candidateId, String resumeUrl) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found!"));

        JobApplication application = new JobApplication();
        application.setJob(job);
        application.setCandidate(candidateId);
        application.setResumePath(resumeUrl);
        application.setAppliedDate(LocalDate.now());

        jobApplicationRepository.save(application);
    }

}

