package com.example.JobMatee.repository;

import com.example.JobMatee.model.SavedCandidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavedCandidateRepository extends JpaRepository<SavedCandidate, Long> {
    List<SavedCandidate> findByRecruiterId(Long recruiterId);
}

