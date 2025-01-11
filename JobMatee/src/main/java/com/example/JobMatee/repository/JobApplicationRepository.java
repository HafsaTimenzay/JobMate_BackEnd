package com.example.JobMatee.repository;

import com.example.JobMatee.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

    List<JobApplication> findByCandidateId(Long candidateId);

    List<JobApplication> findByJobId(Long jobId);
}
