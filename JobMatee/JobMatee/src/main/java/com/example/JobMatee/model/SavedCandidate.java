package com.example.JobMatee.model;

import jakarta.persistence.*;

@Entity
public class SavedCandidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long candidateId;  // Reference to Candidate entity

    @ManyToOne
    @JoinColumn(name = "recruiter_id")
    private Recruiter recruiter;

    private String notes;  // Optional notes about the candidate

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

