package com.example.JobMatee.controller;

import com.example.JobMatee.dto.ProfileDTO;
import com.example.JobMatee.model.CandidateSettings;
import com.example.JobMatee.model.JobApplication;
import com.example.JobMatee.service.CandidateService;
import com.example.JobMatee.service.JobAlertService;
import com.example.JobMatee.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private JobAlertService jobAlertService;

    @Autowired
    private JobService jobService;

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
}

