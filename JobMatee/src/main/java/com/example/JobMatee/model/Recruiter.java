package com.example.JobMatee.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Recruiter {
    @Id
    private Long id;

    @Column(name = "company_logo", nullable = true)
    private String companyLogo;  // Path to logo

    @Column(name = "company_name",nullable = true)
    private String companyName;

    @Column(name = "company_description", length = 2000,nullable = true)
    private String companyDescription;

    @Column(name = "organisation_type",nullable = true)
    private String organisationType;

    @Column(name = "industry_type",nullable = true)
    private String industryType;

    @Column(name = "team_size",nullable = true)
    private String teamSize;

    @Column(name = "year_of_establishment",nullable = true)
    private Integer yearOfEstablishment;

    @Column(name = "website_url",nullable = true)
    private String websiteUrl;

    @Column(name = "linkedin_url",nullable = true)
    private String linkedinUrl;

    @OneToMany(mappedBy = "recruiter", cascade = CascadeType.ALL)
    private List<RecruiterCandidate> recruiterCandidates = new ArrayList<>();


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

    public List<RecruiterCandidate> getRecruiterCandidates() {
        return recruiterCandidates;
    }

    public void setRecruiterCandidates(List<RecruiterCandidate> recruiterCandidates) {
        this.recruiterCandidates = recruiterCandidates;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

