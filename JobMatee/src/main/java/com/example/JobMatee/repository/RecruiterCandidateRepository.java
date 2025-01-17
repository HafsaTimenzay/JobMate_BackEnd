package com.example.JobMatee.repository;

import com.example.JobMatee.model.RecruiterCandidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecruiterCandidateRepository extends JpaRepository<RecruiterCandidate, Long> {
    Optional<RecruiterCandidate> findByRecruiterIdAndCandidateId(Long recruiterId, Long candidateId);
    List<RecruiterCandidate> findByRecruiterIdAndSaved(Long recruiterId, Boolean saved);
}

