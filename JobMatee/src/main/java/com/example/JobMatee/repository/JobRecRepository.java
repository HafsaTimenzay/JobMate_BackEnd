package com.example.JobMatee.repository;

import com.example.JobMatee.model.JobRec;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRecRepository extends JpaRepository<JobRec, Long> {
    List<JobRec> findByRecruiterId(Long recruiterId);
}

