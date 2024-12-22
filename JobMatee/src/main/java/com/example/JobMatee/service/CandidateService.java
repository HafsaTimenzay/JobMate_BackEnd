package com.example.JobMatee.service;

import com.example.JobMatee.model.CandidateSettings;
import com.example.JobMatee.model.JobApplication;
import com.example.JobMatee.repository.CandidateRepository;
import com.example.JobMatee.repository.CandidateSettingsRepository;
import com.example.JobMatee.repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    private CandidateSettingsRepository candidateSettingsRepository;

    /**
     * Fetch the most recent 5 applications of a candidate.
     */
    public List<JobApplication> getRecentApplications(Long candidateId) {
        return jobApplicationRepository.findTop5ByCandidateIdOrderByAppliedDateDesc(candidateId);
    }

    /**
     * Fetch all applications of a candidate.
     */
    public List<JobApplication> getAllApplications(Long candidateId) {
        return jobApplicationRepository.findByCandidateId(candidateId);
    }

    /**
     * Save or update profile settings for a candidate.
     */
    public CandidateSettingsRepository saveOrUpdateProfileSettings(CandidateSettings profileSettings, Long candidateId) {
        CandidateSettings existingSettings = candidateSettingsRepository.findByCandidateId(candidateId);
        if (existingSettings != null) {
            profileSettings.setId(existingSettings.getId());
        }
        return (CandidateSettingsRepository) candidateSettingsRepository.save(profileSettings);
    }

    /**
     * Fetch profile settings for a candidate.
     */
    public CandidateSettings getProfileSettings(Long candidateId) {
        return candidateSettingsRepository.findByCandidateId(candidateId);
    }
}

