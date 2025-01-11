package com.example.JobMatee.dto;

import java.time.LocalDate;

public class JobApplicationDTO {

    private Long id; // For display purposes
    private Long candidateId; // Reference to the candidate
    private Long jobId; // Reference to the job
    private String resumePath; // Optional resume path
    private String additionalNotes; // Any additional notes provided by the candidate
    private String status; // Status of the application (e.g., ACTIVE, REJECTED, etc.)
    private LocalDate appliedDate; // The date when the application was submitted

    // Constructors
    public JobApplicationDTO() {
    }

    public JobApplicationDTO(Long id, Long candidateId, Long jobId, String resumePath, String additionalNotes, String status, LocalDate appliedDate) {
        this.id = id;
        this.candidateId = candidateId;
        this.jobId = jobId;
        this.resumePath = resumePath;
        this.additionalNotes = additionalNotes;
        this.status = status;
        this.appliedDate = appliedDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(LocalDate appliedDate) {
        this.appliedDate = appliedDate;
    }
}
