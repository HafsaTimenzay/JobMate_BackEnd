package com.example.JobMatee.service;

import com.example.JobMatee.model.*;
import com.example.JobMatee.repository.JobApplicationRepository;
import com.example.JobMatee.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobService {
    private final JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
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

