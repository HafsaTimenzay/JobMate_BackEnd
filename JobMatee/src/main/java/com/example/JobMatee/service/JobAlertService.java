package com.example.JobMatee.service;

import com.example.JobMatee.model.JobAlert;
import com.example.JobMatee.repository.JobAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAlertService {

    @Autowired
    private JobAlertRepository jobAlertRepository;

    /**
     * Fetch job alerts for a specific candidate.
     */
    public List<JobAlert> getJobAlertsForCandidate(Long candidateId) {
        return jobAlertRepository.findByCandidateId(candidateId);
    }

    /**
     * Mark a job alert as seen.
     */
    public void markJobAlertAsSeen(Long jobAlertId) {
        JobAlert jobAlert = jobAlertRepository.findById(jobAlertId)
                .orElseThrow(() -> new RuntimeException("Job Alert not found!"));
        jobAlert.setSeen(true);
        jobAlertRepository.save(jobAlert);
    }
}

