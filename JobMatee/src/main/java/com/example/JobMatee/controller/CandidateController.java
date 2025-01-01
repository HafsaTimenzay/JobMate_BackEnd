package com.example.JobMatee.controller;

import com.example.JobMatee.dto.ProfileDTO;
import com.example.JobMatee.model.CandidateSettings;
import com.example.JobMatee.model.Job;
import com.example.JobMatee.model.JobApplication;
import com.example.JobMatee.service.CandidateService;
import com.example.JobMatee.service.FileUploadService;
import com.example.JobMatee.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private JobService jobService;

    @Autowired
    private FileUploadService fileUploadService;

    /**
     * Get the most recent applications for a candidate.
     */
    @GetMapping("/{id}/recent-applications")
    public ResponseEntity<List<JobApplication>> getRecentApplications(@PathVariable Long id) {
        List<JobApplication> applications = candidateService.getRecentApplications(id);
        return ResponseEntity.ok(applications);
    }

    /**
     * Get all job applications for a candidate.
     */
    @GetMapping("/{id}/all-applications")
    public ResponseEntity<List<JobApplication>> getAllApplications(@PathVariable Long id) {
        List<JobApplication> applications = candidateService.getAllApplications(id);
        return ResponseEntity.ok(applications);
    }

    /**
     * Update profile settings for a candidate.
     */
    @PutMapping("/{id}/profile")
    public ResponseEntity<String> updateProfile(@PathVariable Long id, @RequestBody ProfileDTO profileDTO) {
        candidateService.saveOrUpdateProfileSettings(profileDTO.toEntity(), id);
        return ResponseEntity.ok("Profile updated successfully");
    }

    /**
     * Fetch profile settings for a candidate.
     */
    @GetMapping("/{id}/profile")
    public ResponseEntity<CandidateSettings> getProfile(@PathVariable Long id) {
        CandidateSettings profile = candidateService.getProfileSettings(id);
        return ResponseEntity.ok(profile);
    }

    @GetMapping("/{id}/saved-jobs")
    public ResponseEntity<List<Job>> getSavedJobs(@PathVariable Long id) {
        List<Job> savedJobs = candidateService.getSavedJobs(id);
        return ResponseEntity.ok(savedJobs);
    }

    @PostMapping("/{id}/save-job/{jobId}")
    public ResponseEntity<String> saveJob(@PathVariable Long id, @PathVariable Long jobId) {
        Job job = jobService.getJobById(jobId); // Assuming JobService exists
        candidateService.saveJob(id, job);
        return ResponseEntity.ok("Job saved successfully");
    }

    @PostMapping("/{candidateId}/apply/{jobId}")
    public ResponseEntity<String> applyToJob(
            @PathVariable Long candidateId,
            @PathVariable Long jobId,
            @RequestParam("resume") MultipartFile resume,
            @RequestParam("additionalNotes") String additionalNotes) {

        String resumePath = fileUploadService.uploadFile(resume);
        candidateService.applyToJob(candidateId, jobId, resumePath, additionalNotes);

        return ResponseEntity.ok("Application submitted successfully");
    }


    @PutMapping("/{id}/update-email")
    public ResponseEntity<String> updateEmail(@PathVariable Long id, @RequestBody String newEmail) {
        candidateService.updateEmail(id, newEmail);
        return ResponseEntity.ok("Email updated successfully");
    }

    @PutMapping("/{id}/update-password")
    public ResponseEntity<String> updatePassword(@PathVariable Long id, @RequestBody String newPassword) {
        candidateService.updatePassword(id, newPassword);
        return ResponseEntity.ok("Password updated successfully");
    }

    @PostMapping("/{id}/upload-profile-picture")
    public ResponseEntity<String> uploadProfilePicture(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        String path = fileUploadService.uploadFile(file); // Assuming FileStorageService exists
        candidateService.updateProfilePicture(id, path);
        return ResponseEntity.ok("Profile picture uploaded successfully");
    }



}

