package com.example.JobMatee.service;

import com.example.JobMatee.model.*;
import com.example.JobMatee.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class RecruiterService {

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

