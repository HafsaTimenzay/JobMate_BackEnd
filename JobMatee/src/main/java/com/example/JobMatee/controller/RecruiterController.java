package com.example.JobMatee.controller;

import com.example.JobMatee.model.*;
import com.example.JobMatee.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/recruiter")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    @GetMapping("/{id}")
    public ResponseEntity<Recruiter> getRecruiterDetails(@PathVariable Long id) {
        Recruiter recruiter = recruiterService.getRecruiterById(id);
        return ResponseEntity.ok(recruiter);
    }

    @PutMapping("/{id}/company-info")
    public ResponseEntity<String> updateCompanyInfo(@PathVariable Long id, @RequestBody CompanyInfo companyInfo) {
        recruiterService.updateCompanyInfo(id, companyInfo);
        return ResponseEntity.ok("Company information updated successfully");
    }

    @PutMapping("/{id}/contact-info")
    public ResponseEntity<String> updateContactInfo(@PathVariable Long id, @RequestBody ContactInfo contactInfo) {
        recruiterService.updateContactInfo(id, contactInfo);
        return ResponseEntity.ok("Contact information updated successfully");
    }

    @PutMapping("/{id}/social-media")
    public ResponseEntity<String> updateSocialMedia(@PathVariable Long id, @RequestBody SocialMedia socialMedia) {
        recruiterService.updateSocialMedia(id, socialMedia);
        return ResponseEntity.ok("Social media updated successfully");
    }

    @GetMapping("/{id}/jobs")
    public ResponseEntity<List<JobRec>> getJobsByRecruiter(@PathVariable Long id) {
        List<JobRec> jobs = recruiterService.getJobsByRecruiter(id);
        return ResponseEntity.ok(jobs);
    }

    @GetMapping("/{id}/saved-candidates")
    public ResponseEntity<List<SavedCandidate>> getSavedCandidates(@PathVariable Long id) {
        List<SavedCandidate> candidates = recruiterService.getSavedCandidates(id);
        return ResponseEntity.ok(candidates);
    }
}

