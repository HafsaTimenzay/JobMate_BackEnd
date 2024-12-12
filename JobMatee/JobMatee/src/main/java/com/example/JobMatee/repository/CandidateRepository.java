package com.example.JobMatee.repository;

import com.example.JobMatee.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {}
