package com.example.JobMatee.controller;


import com.example.JobMatee.dto.CandidateDTO;
import com.example.JobMatee.dto.CandidateSignupDTO;
import com.example.JobMatee.service.CandidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/candidate")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

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

