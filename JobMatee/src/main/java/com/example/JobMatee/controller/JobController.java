package com.example.JobMatee.controller;

import com.example.JobMatee.model.Candidate;
import com.example.JobMatee.model.Job;
import com.example.JobMatee.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/jobs")
public class JobController {
    @Autowired
    private JobService jobService;
    /**
     * Search and filter jobs based on criteria.
     */
    @GetMapping("/search")
    public ResponseEntity<List<Job>> searchAndFilterJobs(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Double minSalary,
            @RequestParam(required = false) Double maxSalary,
            @RequestParam(required = false) Boolean remote) {
        List<Job> jobs = jobService.searchAndFilterJobs(keyword, location, category, type, minSalary, maxSalary, remote);
        return ResponseEntity.ok(jobs);
    }
    /**
     * Get a job by its ID.
     */
    @GetMapping("/{jobId}")
    public ResponseEntity<Job> getJobById(@PathVariable Long jobId) {
        Job job = jobService.getJobById(jobId);
        return ResponseEntity.ok(job);
    }
    /**
     * Apply to a job by uploading resume and cover letter.
     */
    @PostMapping("/{jobId}/apply")
    public ResponseEntity<String> applyToJob(
            @PathVariable Long jobId,
            @RequestParam Candidate candidateId,
            @RequestParam String resumeUrl,
            @RequestParam String coverLetter) {
        jobService.applyToJob(jobId, candidateId, resumeUrl, coverLetter);
        return ResponseEntity.ok("Application submitted successfully");
    }
}

