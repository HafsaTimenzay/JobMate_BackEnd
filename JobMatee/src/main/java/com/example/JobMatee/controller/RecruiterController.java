package com.example.JobMatee.controller;

import com.example.JobMatee.dto.RecruiterUpdateDTO;
import com.example.JobMatee.model.*;
import com.example.JobMatee.repository.RecruiterRepository;
import com.example.JobMatee.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/recruiter")
public class RecruiterController {


//    @Autowired
//    private RecruiterService recruiterService;
    @Autowired
    private RecruiterRepository recruiterRepository;

    @PutMapping("/update")
    public ResponseEntity<?> updateRecruiter(@RequestBody RecruiterUpdateDTO recruiterUpdateDTO) {
        // Find the recruiter by email
        Recruiter recruiter = recruiterRepository.findByEmail(recruiterUpdateDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("Recruiter not found"));

        // Update fields if they are provided in the DTO
        if (recruiterUpdateDTO.getCompanyName() != null) {
            recruiter.setCompanyName(recruiterUpdateDTO.getCompanyName());
        }
        if (recruiterUpdateDTO.getCompanyDescription() != null) {
            recruiter.setCompanyDescription(recruiterUpdateDTO.getCompanyDescription());
        }
        if (recruiterUpdateDTO.getOrganisationType() != null) {
            recruiter.setOrganisationType(recruiterUpdateDTO.getOrganisationType());
        }
        if (recruiterUpdateDTO.getIndustryType() != null) {
            recruiter.setIndustryType(recruiterUpdateDTO.getIndustryType());
        }
        if (recruiterUpdateDTO.getTeamSize() != null) {
            recruiter.setTeamSize(recruiterUpdateDTO.getTeamSize());
        }
        if (recruiterUpdateDTO.getYearOfEstablishment() != null) {
            recruiter.setYearOfEstablishment(recruiterUpdateDTO.getYearOfEstablishment());
        }
        if (recruiterUpdateDTO.getWebsiteUrl() != null) {
            recruiter.setWebsiteUrl(recruiterUpdateDTO.getWebsiteUrl());
        }
        if (recruiterUpdateDTO.getLinkedinUrl() != null) {
            recruiter.setLinkedinUrl(recruiterUpdateDTO.getLinkedinUrl());
        }
        if (recruiterUpdateDTO.getCompanyLogo() != null) {
            recruiter.setCompanyLogo(recruiterUpdateDTO.getCompanyLogo());
        }

        // Save the updated recruiter
        recruiterRepository.save(recruiter);

        // Return a success response
        return ResponseEntity.ok("Recruiter updated successfully.");
    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Recruiter> getRecruiterDetails(@PathVariable Long id) {
//        Recruiter recruiter = recruiterService.getRecruiterById(id);
//        return ResponseEntity.ok(recruiter);
//    }
//    //post a job
//    @PostMapping("/{id}/post-job")
//    public ResponseEntity<String> postJob(@PathVariable Long id, @RequestBody JobRec jobRec) {
//        recruiterService.postJob(id, jobRec);
//        return ResponseEntity.ok("Job posted successfully");
//    }
//    //enter a job application
//    @GetMapping("/{recruiterId}/job-applications/{jobId}")
//    public ResponseEntity<List<JobApplication>> getJobApplications(
//            @PathVariable Long recruiterId,
//            @PathVariable Long jobId) {
//        List<JobApplication> applications = recruiterService.getJobApplications(recruiterId, jobId);
//        return ResponseEntity.ok(applications);
//    }
//    //save a candidate
//    @PostMapping("/{recruiterId}/save-candidate/{candidateId}")
//    public ResponseEntity<String> saveCandidate(@PathVariable Long recruiterId, @PathVariable Long candidateId) {
//        recruiterService.saveCandidate(recruiterId, candidateId);
//        return ResponseEntity.ok("Candidate saved successfully");
//    }
//    // jobs he posted
//    @GetMapping("/{id}/jobs")
//    public ResponseEntity<List<JobRec>> getJobsByRecruiter(@PathVariable Long id) {
//        List<JobRec> jobs = recruiterService.getJobsByRecruiter(id);
//        return ResponseEntity.ok(jobs);
//    }
//    //get saved candidates
//    @GetMapping("/{id}/saved-candidates")
//    public ResponseEntity<List<SavedCandidate>> getSavedCandidates(@PathVariable Long id) {
//        List<SavedCandidate> candidates = recruiterService.getSavedCandidates(id);
//        return ResponseEntity.ok(candidates);
//    }
//    //update settings
//    @PutMapping("/{id}/update-info")
//    public ResponseEntity<String> updateRecruiterInfo(
//            @PathVariable Long id,
//            @RequestParam(value = "companyLogo", required = false) MultipartFile companyLogo,
//            @RequestParam(value = "companyName", required = false) String companyName,
//            @RequestParam(value = "companyDescription", required = false) String companyDescription,
//            @RequestParam(value = "organisationType", required = false) String organisationType,
//            @RequestParam(value = "industryType", required = false) String industryType,
//            @RequestParam(value = "teamSize", required = false) String teamSize,
//            @RequestParam(value = "yearOfEstablishment", required = false) Integer yearOfEstablishment,
//            @RequestParam(value = "websiteUrl", required = false) String websiteUrl,
//            @RequestParam(value = "linkedinUrl", required = false) String linkedinUrl) {
//
//        recruiterService.updateRecruiterInfo(
//                id,
//                companyLogo,
//                companyName,
//                companyDescription,
//                organisationType,
//                industryType,
//                teamSize,
//                yearOfEstablishment,
//                websiteUrl,
//                linkedinUrl
//        );
//        return ResponseEntity.ok("Recruiter info updated successfully");
//    }

}

