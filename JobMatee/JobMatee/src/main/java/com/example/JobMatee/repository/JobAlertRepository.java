package com.example.JobMatee.repository;

import com.example.JobMatee.model.JobAlert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAlertRepository extends JpaRepository<JobAlert, Long> {
    List<JobAlert> findByCandidateId(Long candidateId);
}
