package com.example.JobMatee.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Recruiter extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "companyLogo")
    private String companyLogo; // Path to logo

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "companyDescription", length = 2000)
    private String companyDescription;

    @Column(name = "organisationType")
    private String organisationType;

    @Column(name = "industryType")
    private String industryType;

    @Column(name = "teamSize")
    private String teamSize;

    @Column(name = "yearOfEstablishment")
    private Integer yearOfEstablishment;

    @Column(name = "websiteUrl")
    private String websiteUrl;

    @Column(name = "linkedinUrl")
    private String linkedinUrl;

    // One-to-Many relationship with Job
    @OneToMany(mappedBy = "recruiter", cascade = CascadeType.ALL)
    private List<JobRec> jobs;

    // One-to-Many relationship with SavedCandidate
    @OneToMany(mappedBy = "recruiter", cascade = CascadeType.ALL)
    private List<SavedCandidate> savedCandidates;

    @Override
    public String getFirstname() {
        return firstname;
    }

    @Override
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String getLastname() {
        return lastname;
    }

    @Override
    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public List<SavedCandidate> getSavedCandidates() {
        return savedCandidates;
    }

    public void setSavedCandidates(List<SavedCandidate> savedCandidates) {
        this.savedCandidates = savedCandidates;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getOrganisationType() {
        return organisationType;
    }

    public void setOrganisationType(String organisationType) {
        this.organisationType = organisationType;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public String getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(String teamSize) {
        this.teamSize = teamSize;
    }

    public Integer getYearOfEstablishment() {
        return yearOfEstablishment;
    }

    public void setYearOfEstablishment(Integer yearOfEstablishment) {
        this.yearOfEstablishment = yearOfEstablishment;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public List<JobRec> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobRec> jobs) {
        this.jobs = jobs;
    }
    // Getters and setters
}

