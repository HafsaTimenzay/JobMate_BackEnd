package com.example.JobMatee.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Recruiter extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private CompanyInfo companyInfo;

    @OneToOne(cascade = CascadeType.ALL)
    private ContactInfo contactInfo;

    @OneToOne(cascade = CascadeType.ALL)
    private SocialMedia socialMedia;

    @OneToMany(mappedBy = "recruiter", cascade = CascadeType.ALL)
    private List<Job> jobs;

    @OneToMany(mappedBy = "recruiter", cascade = CascadeType.ALL)
    private List<SavedCandidate> savedCandidates;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CompanyInfo getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(CompanyInfo companyInfo) {
        this.companyInfo = companyInfo;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public SocialMedia getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(SocialMedia socialMedia) {
        this.socialMedia = socialMedia;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<SavedCandidate> getSavedCandidates() {
        return savedCandidates;
    }

    public void setSavedCandidates(List<SavedCandidate> savedCandidates) {
        this.savedCandidates = savedCandidates;
    }

    // Getters and setters
}

