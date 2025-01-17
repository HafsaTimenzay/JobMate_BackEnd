package com.example.JobMatee.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Collection;

@Getter
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
    private String company; // Company name

    @Column(nullable = false)
    private String location; // Job location (city, remote, etc.)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JobType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JobSubType subType;// Job or Internship type (this can be used to categorize the job as Job or Internship)

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

    @Column(length = 1000,nullable = false)
    private String requirements; // Job requirements (e.g., skills, experience)

    @Column(length = 1000,nullable = false)
    private String benefits; // Benefits offered (e.g., health insurance, flexible hours)

    @Column
    private String companyWebsite; // Link to the company website

    @Column
    private String linkedInUrl;

    @Column
    private String experience;

    @Column
    private String education;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplicationStatus status=ApplicationStatus.ACTIVE;

    @Column(nullable = false)
    private int applications=0;
    // Link to the LinkedIn job posting


    public Long getId() {
        return id;
    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public int getApplications() {
        return applications;
    }

    public void setApplications(int applications) {
        this.applications = applications;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public JobType getType() {
        return type;
    }

    public JobSubType getSubType() {
        return subType;
    }

    public String getCategory() {
        return category;
    }

    public Double getMinSalary() {
        return minSalary;
    }

    public Double getMaxSalary() {
        return maxSalary;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getPostedDate() {
        return postedDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public String getRequirements() {
        return requirements;
    }

    public String getBenefits() {
        return benefits;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public String getLinkedInUrl() {
        return linkedInUrl;
    }

    public String getExperience() {
        return experience;
    }

    public String getEducation() {
        return education;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setType(JobType type) {
        this.type = type;
    }

    public void setSubType(JobSubType subType) {
        this.subType = subType;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setMinSalary(Double minSalary) {
        this.minSalary = minSalary;
    }

    public void setMaxSalary(Double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public void setLinkedInUrl(String linkedInUrl) {
        this.linkedInUrl = linkedInUrl;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setEducation(String education) {
        this.education = education;
    }

}
