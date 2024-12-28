package com.example.JobMatee.service;

import com.example.JobMatee.model.Candidate;
import com.example.JobMatee.model.CandidateSettings;
import com.example.JobMatee.model.Job;
import com.example.JobMatee.model.JobApplication;
import com.example.JobMatee.repository.CandidateRepository;
import com.example.JobMatee.repository.CandidateSettingsRepository;
import com.example.JobMatee.repository.JobApplicationRepository;
import com.example.JobMatee.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    private CandidateSettingsRepository candidateSettingsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JobRepository jobRepository;

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
     * Apply to job
     */

    public void applyToJob(Long candidateId, Long jobId, String resumePath, String additionalNotes) {
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(() -> new RuntimeException("Candidate not found"));
        Job job = jobRepository.findById(jobId).orElseThrow(() -> new RuntimeException("Job not found"));

        JobApplication application = new JobApplication();
        application.setCandidate(candidate);
        application.setJob(job);
        application.setResumePath(resumePath);
        application.setAdditionalNotes(additionalNotes);
        application.setAppliedDate(LocalDate.now());
        application.setStatus("active");

        jobApplicationRepository.save(application);
    }


    /**
     * Fetch profile settings for a candidate.
     */
    public CandidateSettings getProfileSettings(Long candidateId) {
        return candidateSettingsRepository.findByCandidateId(candidateId);
    }

    public List<Job> getSavedJobs(Long candidateId) {
        return candidateRepository.findSavedJobsByCandidateId(candidateId);
    }

    public void saveJob(Long candidateId, Job job) {
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(() -> new RuntimeException("Candidate not found"));
        candidate.getSavedJobs().add(job);
        candidateRepository.save(candidate);
    }

    public void updateEmail(Long candidateId, String newEmail) {
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(() -> new RuntimeException("Candidate not found"));
        candidate.setEmail(newEmail); // Assuming `email` is in `Candidate` or `User` superclass
        candidateRepository.save(candidate);
    }

    public void updatePassword(Long candidateId, String newPassword) {
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(() -> new RuntimeException("Candidate not found"));
        String encodedPassword = passwordEncoder.encode(newPassword); // Assuming PasswordEncoder is used
        candidate.setPassword(encodedPassword);
        candidateRepository.save(candidate);
    }
    public void updateProfilePicture(Long candidateId, String path) {
        CandidateSettings settings = candidateSettingsRepository.findByCandidateId(candidateId);
        if (settings == null) {
            throw new RuntimeException("Candidate settings not found for id: " + candidateId);
        }
        settings.setProfilePicture(path); // Update the profile picture path
        candidateSettingsRepository.save(settings); // Save the changes
    }

}

