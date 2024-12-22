package com.example.JobMatee.repository;

import com.example.JobMatee.model.CandidateSettings;
import com.example.JobMatee.model.JobAlert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateSettingsRepository extends JpaRepository<CandidateSettings, Long> {
    CandidateSettings findByCandidateId(Long candidateId);
}
 