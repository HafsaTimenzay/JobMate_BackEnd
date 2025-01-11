package com.example.JobMatee.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class JobDTO {

    // Getters and Setters
    private Long id;  // Job ID
    private Long recruiterId;  // Reference to the recruiter posting the job
    private String title;  // Job title
    private Double salary;  // Fixed salary (if applicable)
    private String company;  // Company name
    private String location;  // Job location
    private String type;  // Job or internship type (represented as a string to avoid tight coupling with enums)
    private String category;  // Optional category of the job
    private Double minSalary;  // Minimum salary range
    private Double maxSalary;  // Maximum salary range
    private String description;  // Detailed job description
    private LocalDate postedDate;  // Date when the job was posted
    private LocalDate expirationDate;  // Date when the job expires
    private boolean remote;  // Indicates if the job is remote
    private String requirements;  // Skills or qualifications needed
    private String benefits;  // Benefits offered
    private String companyWebsite;  // Link to company website
    private String linkedInUrl;  // Link to LinkedIn job posting

    // Constructors
    public JobDTO() {
    }

    public JobDTO(Long id, Long recruiterId, String title, Double salary, String company, String location, String type,
                  String category, Double minSalary, Double maxSalary, String description, LocalDate postedDate,
                  LocalDate expirationDate, boolean remote, String requirements, String benefits,
                  String companyWebsite, String linkedInUrl) {
        this.id = id;
        this.recruiterId = recruiterId;
        this.title = title;
        this.salary = salary;
        this.company = company;
        this.location = location;
        this.type = type;
        this.category = category;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.description = description;
        this.postedDate = postedDate;
        this.expirationDate = expirationDate;
        this.remote = remote;
        this.requirements = requirements;
        this.benefits = benefits;
        this.companyWebsite = companyWebsite;
        this.linkedInUrl = linkedInUrl;
    }

}

