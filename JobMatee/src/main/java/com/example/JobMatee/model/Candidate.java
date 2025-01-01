package com.example.JobMatee.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name = "Candidate")
public class Candidate extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "jobTitle")
    private String jobTitle;

    @Column(name = "personalWebsite")
    private String personalWebsite;

    @Column(name = "resumePath")
    private String resumePath; // Path to the uploaded resume

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<JobApplication> applications;

    @ManyToMany
    @JoinTable(
            name = "candidate_saved_jobs",
            joinColumns = @JoinColumn(name = "candidate_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id")
    )
    private List<Job> savedJobs = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public List<Job> getSavedJobs() {
        return savedJobs;
    }

    public void setSavedJobs(List<Job> savedJobs) {
        this.savedJobs = savedJobs;
    }
}
