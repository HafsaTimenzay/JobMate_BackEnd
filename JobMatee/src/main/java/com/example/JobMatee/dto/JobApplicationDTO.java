package com.example.JobMatee.dto;

import java.time.LocalDate;

public class JobApplicationDTO {

    private Long id;
    private String description;
    private String resumePath;
    private String jobTitle; // Title of the job from Job entity
    private String candidateName; // Full name of the candidate from Candidate entity
    private String location; // Location of the job
    private String type; // Job type (e.g., Full Time, Part Time, Remote)
    private Double maxSalary; // Maximum salary for the job
    private Double minSalary; // Minimum salary for the job
    private String appliedDate; // Date the application was submitted
    private String status; // Application status

    // Default Constructor
    public JobApplicationDTO() {}

    // Parameterized Constructor
    public JobApplicationDTO(Long id, String description, String resumePath, String jobTitle, String candidateName,
                             String location, String type, Double maxSalary, Double minSalary, String appliedDate, String status) {
        this.id = id;
        this.description = description;
        this.resumePath = resumePath;
        this.jobTitle = jobTitle;
        this.candidateName = candidateName;
        this.location = location;
        this.type = type;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
        this.appliedDate = appliedDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public Double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Double minSalary) {
        this.minSalary = minSalary;
    }

    public String getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

