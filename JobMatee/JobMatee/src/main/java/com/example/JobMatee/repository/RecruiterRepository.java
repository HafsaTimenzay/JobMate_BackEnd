package com.example.JobMatee.repository;

import com.example.JobMatee.model.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {
    Recruiter findByEmail(String email);
}

