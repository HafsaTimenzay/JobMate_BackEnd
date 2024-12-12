package com.example.JobMatee.service;

import com.example.JobMatee.model.Job;
import com.example.JobMatee.model.JobApplication;
import com.example.JobMatee.repository.JobApplicationRepository;
import com.example.JobMatee.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    private JobRepository jobRepository;

    /**
     * Search and filter jobs based on criteria.
     */
    public List<Job> searchAndFilterJobs(String keyword, String location, String category, String type, Double minSalary, Double maxSalary, Boolean remote) {
        return jobRepository.findByCriteria(keyword, location, category, type, minSalary, maxSalary, remote);
    }

    /**
     * Fetch a job by its ID.
     */
    public Job getJobById(Long jobId) {
        return jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found!"));
    }

    public void applyToJob(Long jobId, Long candidateId, String resumeUrl, String coverLetter) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found!"));

        JobApplication application = new JobApplication();
        application.setJob(job);
        application.setCandidateId(candidateId);
        application.setResumeUrl(resumeUrl);
        application.setCoverLetter(coverLetter);
        application.setAppliedDate(LocalDate.now());

        jobApplicationRepository.save(application);
    }

}

