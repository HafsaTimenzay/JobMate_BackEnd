package com.example.JobMatee.repository;

import com.example.JobMatee.model.Candidate;
import com.example.JobMatee.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}

