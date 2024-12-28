package com.example.JobMatee.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recruiter_id", nullable = false)
    private Recruiter recruiter;

    @Column(nullable = false)
    private String title; // Job title

    @Column(nullable = false)
    private Double salary;

    @Column(nullable = false)
    private String company; // Company name

    @Column(nullable = false)
    private String location; // Job location (city, remote, etc.)

    @Column(nullable = false)
    private String type; // e.g., "full-time", "part-time"

    private String category; // Job category (optional, can be null)

    @Column(nullable = false)
    private Double minSalary; // Minimum salary range

    @Column(nullable = false)
    private Double maxSalary; // Maximum salary range

    @Column(length = 2000, nullable = false)
    private String description; // Detailed job description

    @Column(nullable = false)
    private LocalDate postedDate; // Date the job was posted

    @Column(nullable = false)
    private LocalDate expirationDate; // Date the job expires

    @Column(nullable = false)
    private boolean remote; // Indicates if the job is remote

    @Column(length = 1000)
    private String requirements; // Job requirements (e.g., skills, experience)

    @Column(length = 1000)
    private String benefits; // Benefits offered (e.g., health insurance, flexible hours)

    private String companyWebsite; // Link to the company website
    private String linkedInUrl; // Link to the LinkedIn job posting

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Double minSalary) {
        this.minSalary = minSalary;
    }

    public Double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getLinkedInUrl() {
        return linkedInUrl;
    }

    public void setLinkedInUrl(String linkedInUrl) {
        this.linkedInUrl = linkedInUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }
}

