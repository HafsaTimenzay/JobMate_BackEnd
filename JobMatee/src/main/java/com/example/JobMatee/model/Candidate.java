package com.example.JobMatee.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;


@Entity
@Data
@Table(name = "Candidate")
public class Candidate extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "jobTitle")
    private String jobTitle;

    @Column(name = "personalWebsite")
    private String personalWebsite;

    @Column(name = "resumePath")
    private String resumePath; // Path to the uploaded resume

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<JobApplication> applications;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<JobAlert> alerts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPersonalWebsite() {
        return personalWebsite;
    }

    public void setPersonalWebsite(String personalWebsite) {
        this.personalWebsite = personalWebsite;
    }

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }

    public List<JobApplication> getApplications() {
        return applications;
    }

    public void setApplications(List<JobApplication> applications) {
        this.applications = applications;
    }

    public List<JobAlert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<JobAlert> alerts) {
        this.alerts = alerts;
    }
}
