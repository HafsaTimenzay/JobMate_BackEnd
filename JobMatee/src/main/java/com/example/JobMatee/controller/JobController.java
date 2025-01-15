package com.example.JobMatee.controller;

import com.example.JobMatee.dto.JobPostRequest;
import com.example.JobMatee.model.*;
import com.example.JobMatee.repository.JobRepository;
import com.example.JobMatee.repository.RecruiterRepository;
import com.example.JobMatee.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/jobs")
public class JobController {
    private final JobService jobService;
    private final RecruiterRepository recruiterRepository;
    private final JobRepository jobRepository;

    @Autowired
    public JobController(JobService jobService, RecruiterRepository recruiterRepository, JobRepository jobRepository) {
        this.jobService = jobService;
        this.recruiterRepository = recruiterRepository;
        this.jobRepository = jobRepository;
    }

    // Créer un job
    @PostMapping("/create")
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        Job createdJob = jobService.createJob(job);
        return ResponseEntity.ok(createdJob);
    }

    // Afficher tous les jobs
    @GetMapping("/all")
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }
    @PostMapping("/post")
    public ResponseEntity<?> postJob(@RequestBody JobPostRequest jobPostRequest) {
        try {
            // Find the recruiter by email
            Recruiter recruiter = recruiterRepository.findByEmail(jobPostRequest.getEmail())
                    .orElseThrow(() -> new RuntimeException("Recruiter not found"));

            // Create a new Job entity
            Job job = new Job();
            job.setRecruiter(recruiter);
            job.setTitle(jobPostRequest.getTitle());
            job.setCompany(jobPostRequest.getCompany());
            job.setLocation(jobPostRequest.getLocation());
            job.setType(JobType.valueOf(jobPostRequest.getType()));
            job.setSubType(JobSubType.valueOf(jobPostRequest.getSubType()));
            job.setMinSalary(jobPostRequest.getMinSalary());
            job.setMaxSalary(jobPostRequest.getMaxSalary());
            job.setDescription(jobPostRequest.getDescription());
            job.setPostedDate(LocalDate.parse(jobPostRequest.getPostedDate()));
            job.setExpirationDate(LocalDate.parse(jobPostRequest.getExpirationDate()));
            job.setRequirements(jobPostRequest.getRequirements());
            job.setBenefits(jobPostRequest.getBenefits());
            job.setExperience(jobPostRequest.getExperience());
            job.setEducation(jobPostRequest.getEducation());
            job.setCompanyWebsite(jobPostRequest.getCompanyWebsite());
            job.setLinkedInUrl(jobPostRequest.getLinkedInUrl());

            // Save the job
            jobRepository.save(job);

            return ResponseEntity.ok("Job posted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error posting job: " + e.getMessage());
        }
    }
//    @Autowired
//    private JobService jobService;
//    /**
//     * Search and filter jobs based on criteria.
//     */
//    @GetMapping("/search")
//    public ResponseEntity<List<Job>> searchAndFilterJobs(
//            @RequestParam(required = false) String keyword,
//            @RequestParam(required = false) String location,
//            @RequestParam(required = false) String category,
//            @RequestParam(required = false) String type,
//            @RequestParam(required = false) Double minSalary,
//            @RequestParam(required = false) Double maxSalary,
//            @RequestParam(required = false) Boolean remote) {
//        List<Job> jobs = jobService.searchAndFilterJobs(keyword, location, category, type, minSalary, maxSalary, remote);
//        return ResponseEntity.ok(jobs);
//    }
//    /**
//     * Get a job by its ID.
//     */
//    @GetMapping("/{jobId}")
//    public ResponseEntity<Job> getJobById(@PathVariable Long jobId) {
//        Job job = jobService.getJobById(jobId);
//        return ResponseEntity.ok(job);
//    }
//    /**
//     * Apply to a job by uploading resume and cover letter.
//     */
    @PostMapping("/{jobId}/apply")
    public ResponseEntity<String> applyToJob(
            @PathVariable Long jobId,
            @RequestParam Candidate id,
            @RequestParam String resumeUrl) {
        jobService.applyToJob(jobId, id, resumeUrl);
        return ResponseEntity.ok("Application submitted successfully");
    }
}

