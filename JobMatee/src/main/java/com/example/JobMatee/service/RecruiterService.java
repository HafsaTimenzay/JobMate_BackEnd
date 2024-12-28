package com.example.JobMatee.service;

import com.example.JobMatee.model.*;
import com.example.JobMatee.repository.JobRecRepository;
import com.example.JobMatee.repository.RecruiterRepository;
import com.example.JobMatee.repository.SavedCandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruiterService {

    @Autowired
    private RecruiterRepository recruiterRepository;

    @Autowired
    private SavedCandidateRepository savedCandidateRepository;

    @Autowired
    private JobRecRepository jobRepository;

    public Recruiter getRecruiterById(Long id) {
        return recruiterRepository.findById(id).orElseThrow(() -> new RuntimeException("Recruiter not found"));
    }

    public void updateCompanyInfo(Long recruiterId, CompanyInfo companyInfo) {
        Recruiter recruiter = getRecruiterById(recruiterId);
        recruiter.setCompanyInfo(companyInfo);
        recruiterRepository.save(recruiter);
    }

    public void updateContactInfo(Long recruiterId, ContactInfo contactInfo) {
        Recruiter recruiter = getRecruiterById(recruiterId);
        recruiter.setContactInfo(contactInfo);
        recruiterRepository.save(recruiter);
    }

    public List<JobRec> getJobsByRecruiter(Long recruiterId) {
        return jobRepository.findByRecruiterId(recruiterId);
    }

    public List<SavedCandidate> getSavedCandidates(Long recruiterId) {
        return savedCandidateRepository.findByRecruiterId(recruiterId);
    }

    public void saveCandidate(SavedCandidate savedCandidate) {
        savedCandidateRepository.save(savedCandidate);
    }
}

