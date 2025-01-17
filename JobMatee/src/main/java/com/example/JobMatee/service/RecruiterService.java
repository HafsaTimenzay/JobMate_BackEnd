package com.example.JobMatee.service;

import com.example.JobMatee.dto.RecruiterSignUpDTO;
import com.example.JobMatee.model.*;
import com.example.JobMatee.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class RecruiterService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecruiterRepository recruiterRepository;
    @Autowired
    private final CandidateRepository candidateRepository;
    @Autowired
    private final RecruiterCandidateRepository recruiterCandidateRepository;


    public Recruiter findRecruiterByEmail(String email) {
        // Find the user by email to get the user ID
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Check if the user is a recruiter
        if (user.getRole() != Role.RECRUITER) {
            throw new IllegalArgumentException("User is not a recruiter");
        }

        // Find and return the recruiter by user ID
        return recruiterRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("Recruiter not found with user ID: " + user.getId()));
    }

    public RecruiterService(RecruiterRepository recruiterRepository, CandidateRepository candidateRepository, RecruiterCandidateRepository recruiterCandidateRepository) {
        this.recruiterRepository = recruiterRepository;
        this.candidateRepository = candidateRepository;
        this.recruiterCandidateRepository = recruiterCandidateRepository;
    }

    public void saveCandidateForRecruiter(Long recruiterId, Long candidateId, Boolean saveStatus) {
        Recruiter recruiter = recruiterRepository.findById(recruiterId)
                .orElseThrow(() -> new EntityNotFoundException("Recruiter not found"));
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new EntityNotFoundException("Candidate not found"));

        RecruiterCandidate rc = recruiterCandidateRepository.findByRecruiterIdAndCandidateId(recruiterId, candidateId)
                .orElse(new RecruiterCandidate());
        rc.setRecruiter(recruiter);
        rc.setCandidate(candidate);
        rc.setSaved(saveStatus);

        recruiterCandidateRepository.save(rc);
    }


    public Recruiter updateRecruiterByEmail(String email, Recruiter updatedRecruiter) {
        // Find the recruiter by email
        Recruiter existingRecruiter = findRecruiterByEmail(email);

        // Update recruiter fields
        existingRecruiter.setCompanyName(updatedRecruiter.getCompanyName());
        existingRecruiter.setCompanyLogo(updatedRecruiter.getCompanyLogo());
        existingRecruiter.setCompanyDescription(updatedRecruiter.getCompanyDescription());
        existingRecruiter.setOrganisationType(updatedRecruiter.getOrganisationType());
        existingRecruiter.setIndustryType(updatedRecruiter.getIndustryType());
        existingRecruiter.setTeamSize(updatedRecruiter.getTeamSize());
        existingRecruiter.setYearOfEstablishment(updatedRecruiter.getYearOfEstablishment());
        existingRecruiter.setWebsiteUrl(updatedRecruiter.getWebsiteUrl());
        existingRecruiter.setLinkedinUrl(updatedRecruiter.getLinkedinUrl());

        // Save and return the updated recruiter
        return recruiterRepository.save(existingRecruiter);
    }


//    @Autowired
//    private RecruiterRepository recruiterRepository;
//
//    @Autowired
//    private SavedCandidateRepository savedCandidateRepository;
//
//    @Autowired
//    private JobRecRepository jobRepository;
//
//    @Autowired
//    private JobApplicationRepository jobApplicationRepository;
//
//    @Autowired
//    private CandidateRepository candidateRepository;
//
//    @Autowired
//    private FileUploadService fileUploadService;
//
//    public Recruiter getRecruiterById(Long id) {
//        return recruiterRepository.findById(id).orElseThrow(() -> new RuntimeException("Recruiter not found"));
//    }
//
//    public List<JobRec> getJobsByRecruiter(Long recruiterId) {
//        return jobRepository.findByRecruiterId(recruiterId);
//    }
//
//    public List<SavedCandidate> getSavedCandidates(Long recruiterId) {
//        return savedCandidateRepository.findByRecruiterId(recruiterId);
//    }
//    public void saveCandidate(SavedCandidate savedCandidate) {
//        savedCandidateRepository.save(savedCandidate);
//    }
//    // Post a job
//    public void postJob(Long recruiterId, JobRec jobRec) {
//        Recruiter recruiter = getRecruiterById(recruiterId);
//        jobRec.setRecruiter(recruiter);
//        jobRepository.save(jobRec);
//    }
//
//    // View job applications
//    public List<JobApplication> getJobApplications(Long recruiterId, Long jobId) {
//        JobRec job = jobRepository.findById(jobId)
//                .orElseThrow(() -> new RuntimeException("Job not found"));
//        if (!job.getRecruiter().getId().equals(recruiterId)) {
//            throw new RuntimeException("Access denied");
//        }
//        return jobApplicationRepository.findByJobId(jobId);
//    }
//
//    // Save a candidate
//    public void saveCandidate(Long recruiterId, Long id) {
//        Recruiter recruiter = getRecruiterById(recruiterId);
//        Candidate candidate = candidateRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Candidate not found"));
//
//        SavedCandidate savedCandidate = new SavedCandidate();
//        savedCandidate.setRecruiter(recruiter);
//        savedCandidate.setCandidateId(candidate.getId());
//        savedCandidateRepository.save(savedCandidate);
//    }
//
//    public void updateRecruiterInfo(
//            Long recruiterId,
//            MultipartFile companyLogo,
//            String companyName,
//            String companyDescription,
//            String organisationType,
//            String industryType,
//            String teamSize,
//            Integer yearOfEstablishment,
//            String websiteUrl,
//            String linkedinUrl) {
//
//        Recruiter recruiter = recruiterRepository.findById(recruiterId)
//                .orElseThrow(() -> new RuntimeException("Recruiter not found"));
//
//        // Update fields if they are not null
//        if (companyLogo != null) {
//            String logoPath = fileUploadService.uploadFile(companyLogo);
//            recruiter.setCompanyLogo(logoPath);
//        }
//        if (companyName != null) recruiter.setCompanyName(companyName);
//        if (companyDescription != null) recruiter.setCompanyDescription(companyDescription);
//        if (organisationType != null) recruiter.setOrganisationType(organisationType);
//        if (industryType != null) recruiter.setIndustryType(industryType);
//        if (teamSize != null) recruiter.setTeamSize(teamSize);
//        if (yearOfEstablishment != null) recruiter.setYearOfEstablishment(yearOfEstablishment);
//        if (websiteUrl != null) recruiter.setWebsiteUrl(websiteUrl);
//        if (linkedinUrl != null) recruiter.setLinkedinUrl(linkedinUrl);
//
//        recruiterRepository.save(recruiter);
//    }

}

