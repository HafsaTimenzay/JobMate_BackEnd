package com.example.JobMatee.model;

import jakarta.persistence.*;

@Entity
public class CompanyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "companyInfo")
    private Recruiter recruiter;

    private String logoUrl;  // Path to the uploaded logo
    private String name;
    private String description;
    private String companyType;
    private String industryType;
    private int teamSize;
    private int yearEstablished;
    private String website;

    public String getLogoUrl() {
        return logoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public int getYearEstablished() {
        return yearEstablished;
    }

    public void setYearEstablished(int yearEstablished) {
        this.yearEstablished = yearEstablished;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }


}

