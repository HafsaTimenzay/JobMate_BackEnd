package com.example.JobMatee.controller;

import com.example.JobMatee.dto.JobApplicationDTO;
import com.example.JobMatee.model.ApplicationStatus;
import com.example.JobMatee.model.Candidate;
import com.example.JobMatee.model.Job;
import com.example.JobMatee.model.JobApplication;
import com.example.JobMatee.repository.CandidateRepository;
import com.example.JobMatee.repository.JobApplicationRepository;
import com.example.JobMatee.repository.JobRepository;
import com.example.JobMatee.service.FileStorageService;
import com.example.JobMatee.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "http://localhost:3000")
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    private FileStorageService fileUploadService; // Inject the FileUploadService

    @PostMapping(value = "/apply", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> apply(
            @RequestParam("email") String email,
            @RequestParam("jobId") Long jobId,
            @RequestParam("resume") MultipartFile resume,
            @RequestParam("description") String description
    ) {
        try {
            // Fetch the candidate and job entities
            Candidate candidate = jobApplicationService.findCandidateByEmail(email);
            Job job = jobRepository.findById(jobId)
                    .orElseThrow(() -> new RuntimeException("Job not found"));

            // Validate file type
            if (!resume.getContentType().equals("application/pdf")) {
                throw new RuntimeException("Only PDF files are allowed for resumes.");
            }

            // Save the resume file and get its path
            String resumePath = fileUploadService.saveFile(resume);

            // Create and save the job application
            JobApplication application = new JobApplication();
            application.setCandidate(candidate);
            application.setJob(job);
            application.setDescription(description);
            application.setResumePath(resumePath);
            application.setStatus(ApplicationStatus.ACTIVE);
            application.setAppliedDate(LocalDate.now());

            jobApplicationRepository.save(application);

            return ResponseEntity.ok("Application submitted successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/candidates")
    public ResponseEntity<List<Candidate>> getCandidatesByJobId(@RequestParam Long jobId) {
        try {
            // Fetch job applications for the given job
            List<JobApplication> applications = jobApplicationRepository.findAllByJobId(jobId);

            // Extract the candidates
            List<Candidate> candidates = applications.stream()
                    .map(JobApplication::getCandidate)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(candidates);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.emptyList());
        }
    }

//    @PostMapping(value = "/apply", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<String> apply(
//            @RequestParam("email") String email,
//            @RequestParam("jobId") Long jobId,
//            @RequestBody JobApplicationDTO jobApplicationDTO
//
//    ) {
//        try {
//            // Fetch the candidate and job entities
//            Candidate candidate = jobApplicationService.findCandidateByEmail(email);
//            Job job = jobRepository.findById(jobId)
//                    .orElseThrow(() -> new RuntimeException("Job not found"));
//
//            // Use FileUploadService to save the resume file and get its path
//
//            // String resumePath = fileUploadService.saveFile(resume);
//
//            // Create and save the job application
//            JobApplication application = new JobApplication();
//            application.setCandidate(candidate);
//            application.setJob(job);
//            application.setDescription(jobApplicationDTO.getDescription());
//            application.setResumePath(jobApplicationDTO.getResumePath());
//            application.setStatus(ApplicationStatus.ACTIVE);
//            application.setAppliedDate(LocalDate.now());
//
//            jobApplicationRepository.save(application);
//
//            return ResponseEntity.ok("Application submitted successfully!");
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//    }

    @GetMapping("/all")
    public ResponseEntity<List<JobApplicationDTO>> getCandidateApplications(@RequestParam String email) {
        Candidate candidate = jobApplicationService.findCandidateByEmail(email);
        List<JobApplication> applications = jobApplicationService.getApplicationsByCandidate(candidate.getId());

        List<JobApplicationDTO> dtos = applications.stream().map(app -> {
            JobApplicationDTO dto = new JobApplicationDTO();
            dto.setId(app.getId());
            dto.setDescription(app.getDescription());
            dto.setResumePath(app.getResumePath());
            dto.setJobTitle(app.getJob().getTitle());
            dto.setCandidateName(app.getCandidate().getFirstname() + " " + app.getCandidate().getLastname());
            dto.setLocation(app.getJob().getLocation()); // Assuming Job entity has a `location` field
            dto.setType(app.getJob().getType().toString()); // Assuming Job entity has a `type` field
            dto.setMaxSalary(app.getJob().getMaxSalary()); // Assuming Job entity has a `maxSalary` field
            dto.setMinSalary(app.getJob().getMinSalary()); // Assuming Job entity has a `minSalary` field
            dto.setAppliedDate(app.getAppliedDate().toString()); // Convert LocalDate to String
            dto.setStatus(app.getStatus().toString()); // Convert ApplicationStatus enum to String
            return dto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }


}