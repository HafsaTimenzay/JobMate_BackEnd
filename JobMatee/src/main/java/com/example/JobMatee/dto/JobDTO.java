package com.example.JobMatee.dto;

import com.example.JobMatee.model.ApplicationStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class JobDTO {
    private Long id;
    private String title;
    private String jobType;
    private String datePosted;
    private ApplicationStatus status;
    private int applicationsTotal;

    public JobDTO(Long id, String title, String jobType, String datePosted, ApplicationStatus status, int applicationsTotal) {
        this.id = id;
        this.title = title;
        this.jobType = jobType;
        this.datePosted = datePosted;
        this.status = ApplicationStatus.ACTIVE;
        this.applicationsTotal = 0;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public int getApplicationsTotal() {
        return applicationsTotal;
    }

    public void setApplicationsTotal(int applicationsTotal) {
        this.applicationsTotal = applicationsTotal;
    }
}


