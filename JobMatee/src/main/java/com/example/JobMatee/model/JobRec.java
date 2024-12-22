package com.example.JobMatee.model;

import jakarta.persistence.*;

@Entity
public class JobRec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "jobType")
    private String jobType;  // Full-time, Part-time, etc.

    @Column(name = "salary")
    private double salary;

    @Column(name = "isRemote")
    private boolean isRemote;

    @ManyToOne
    @JoinColumn(name = "recruiter_id")
    private Recruiter recruiter;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isRemote() {
        return isRemote;
    }

    public void setRemote(boolean remote) {
        isRemote = remote;
    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }
}

