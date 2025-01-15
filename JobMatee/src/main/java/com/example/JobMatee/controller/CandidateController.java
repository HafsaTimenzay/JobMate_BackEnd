package com.example.JobMatee.controller;


import com.example.JobMatee.dto.CandidateDTO;
import com.example.JobMatee.dto.CandidateSignupDTO;
import com.example.JobMatee.model.Candidate;
import com.example.JobMatee.model.JobApplication;
import com.example.JobMatee.model.Role;
import com.example.JobMatee.model.User;
import com.example.JobMatee.repository.CandidateRepository;
import com.example.JobMatee.repository.UserRepository;
import com.example.JobMatee.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/candidate")
public class CandidateController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    // Function to get candidate data using email
    @GetMapping("/findByEmail")
    public ResponseEntity<Object> getCandidateByEmail(@RequestParam("email") String email) {
        // Find the user by email to get the user id
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));;

        if (user != null && user.getRole() == Role.CANDIDATE) {
            // Use the user id to find the candidate
            Candidate candidate = candidateRepository.findById(user.getId()).orElse(null);

            if (candidate != null) {
                return ResponseEntity.ok(candidate);  // Return candidate if found
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Candidate not found.");  // Return error message
            }
        } else {
            // Return an error message if user is not a candidate
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is not a candidate or doesn't exist");
        }
    }

    public ResponseEntity<List<JobApplication>> getApplications(@PathVariable String email) {
        List<JobApplication> applications = candidateService.getApplicationsByEmail(email);
        return ResponseEntity.ok(applications);
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<Candidate> updateCandidate(@PathVariable Long id, @RequestBody Candidate updatedCandidate) {
//        try {
//            Candidate updated = candidateService.updateCandidate(id, updatedCandidate);
//            return ResponseEntity.ok(updated);
//        } catch (Exception e) {
//            return ResponseEntity.status(404).body(null);  // Candidate not found
//        }
//    }

    // Find and update a candidate by email
//    @PutMapping("/updateByEmail")
//    public ResponseEntity<Object> updateCandidateByEmail(@RequestParam("email") String email, @RequestBody Candidate updatedCandidate) {
//        // Find the user by email to get the user id
//        User user = userRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with the provided email"));
//
//        if (user != null && user.getRole() == Role.CANDIDATE) {
//            // Use the user id to find the candidate
//            Candidate existingCandidate = candidateRepository.findById(user.getId())
//                    .orElseThrow(() -> new RuntimeException("Candidate not found with the provided user ID"));
//
//            // Update candidate fields (you can add more fields as necessary)
//            existingCandidate.setFirstname(updatedCandidate.getFirstname());
//            existingCandidate.setLastname(updatedCandidate.getLastname());
//            existingCandidate.setDateOfBirth(updatedCandidate.getDateOfBirth());
//            existingCandidate.setGender(updatedCandidate.getGender());
//            existingCandidate.setCity(updatedCandidate.getCity());
//            existingCandidate.setPhoneNumber(updatedCandidate.getPhoneNumber());
//            existingCandidate.setProfilePicture(updatedCandidate.getProfilePicture());
//            existingCandidate.setResumePath(updatedCandidate.getResumePath());
//            existingCandidate.setJobTitle(updatedCandidate.getJobTitle());
//            existingCandidate.setEducationLevel(updatedCandidate.getEducationLevel());
//            existingCandidate.setExperienceYears(updatedCandidate.getExperienceYears());
//            existingCandidate.setBio(updatedCandidate.getBio());
//            existingCandidate.setPersonalWebsite(updatedCandidate.getPersonalWebsite());
//            existingCandidate.setLinkedinUrl(updatedCandidate.getLinkedinUrl());
////            existingCandidate.setSaved(updatedCandidate.getSaved());
//
//            // Save the updated candidate
//            candidateRepository.save(existingCandidate);
//            return ResponseEntity.ok(existingCandidate);
//        } else {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is not a candidate or doesn't exist");
//        }
//    }

    @PutMapping("/updateByEmail")
    public ResponseEntity<Candidate> updateCandidateByEmail(@RequestParam("email") String email, @RequestBody Candidate updatedCandidate) {
        try {
            Candidate existingCandidate = candidateService.findCandidateByEmail(email);

            // Update fields
            existingCandidate.setFirstname(updatedCandidate.getFirstname());
            existingCandidate.setLastname(updatedCandidate.getLastname());
            existingCandidate.setDateOfBirth(updatedCandidate.getDateOfBirth());
            existingCandidate.setGender(updatedCandidate.getGender());
            existingCandidate.setCity(updatedCandidate.getCity());
            existingCandidate.setPhoneNumber(updatedCandidate.getPhoneNumber());
            existingCandidate.setProfilePicture(updatedCandidate.getProfilePicture());
            existingCandidate.setResumePath(updatedCandidate.getResumePath());
            existingCandidate.setJobTitle(updatedCandidate.getJobTitle());
            existingCandidate.setEducationLevel(updatedCandidate.getEducationLevel());
            existingCandidate.setExperienceYears(updatedCandidate.getExperienceYears());
            existingCandidate.setBio(updatedCandidate.getBio());
            existingCandidate.setPersonalWebsite(updatedCandidate.getPersonalWebsite());
            existingCandidate.setLinkedinUrl(updatedCandidate.getLinkedinUrl());
            // ... (other fields)

            candidateRepository.save(existingCandidate);
            return ResponseEntity.ok(existingCandidate);
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Return specific error for user not found
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Return specific error for non-candidate user
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Generic error for candidate not found
        }
    }






//    @GetMapping("/profile/{email}")
//    public ResponseEntity<?> getCandidateProfile(@PathVariable String email) {
//        Candidate candidate = candidateService.getCandidateByUserEmail(email);
//        if (candidate == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Candidate not found");
//        }
//        Map<String, String> response = new HashMap<>();
//        response.put("firstname", candidate.getFirstname());
//        response.put("lastname", candidate.getLastname());
//        return ResponseEntity.ok(response);
//    }



    // Create a new candidate
//    @PostMapping("/create")
//    public ResponseEntity<CandidateDTO> createCandidate(@RequestBody CandidateSignupDTO createDTO) {
//        CandidateDTO candidateDTO = candidateService.createCandidate(createDTO);
//        return ResponseEntity.ok(candidateDTO);
//    }

    // Get all candidates
//    @GetMapping
//    public ResponseEntity<List<CandidateDTO>> getAllCandidates() {
//        List<CandidateDTO> candidates = candidateService.getAllCandidates();
//        return ResponseEntity.ok(candidates);
//    }
//
//    // Get a candidate by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<CandidateDTO> getCandidateById(@PathVariable Long id) {
//        CandidateDTO candidate = candidateService.getCandidateById(id);
//        return ResponseEntity.ok(candidate);
//    }
//
//    // Update a candidate by ID
//    @PutMapping("/{id}")
//    public ResponseEntity<CandidateDTO> updateCandidate(@PathVariable Long id, @RequestBody CandidateDTO candidateDTO) {
//        CandidateDTO updatedCandidate = candidateService.updateCandidate(id, candidateDTO);
//        return ResponseEntity.ok(updatedCandidate);
//    }
//
//    // Delete a candidate by ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCandidate(@PathVariable Long id) {
//        candidateService.deleteCandidate(id);
//        return ResponseEntity.noContent().build();
//    }
}

