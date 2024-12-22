package com.example.JobMatee.model;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class CandidateSettings {

    // Getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate; // Candidate linked to these settings

    // Personal Info
    @Column(name = "profilePicture")
    private String profilePicture; // Path to the uploaded profile picture

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "jobTitle")
    private String jobTitle;

    @Column(name = "personalWebsite")
    private String personalWebsite;

    @Column(name = "resumePath")
    private String resumePath;

    @Column(name = "location")
    private String location;

    // Profile
    @Column(name = "nationality")
    private String nationality;

    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "educationLevel")
    private String educationLevel;

    @Column(name = "experienceYears")
    private Integer experienceYears; // Number of years of experience


    @Column(name = "biography", length = 2000)
    private String biography;

    // Social Links
    private String linkedIn;
    private String github;
    private String twitter;

    // Account Settings
    private String phoneNumber;
    private String preferredJobLocation;
    private String preferredJobRole;
    private boolean profilePrivate; // If the profile is private
    private boolean allowJobAlerts; // If the candidate wants job alerts

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPreferredJobLocation() {
        return preferredJobLocation;
    }

    public void setPreferredJobLocation(String preferredJobLocation) {
        this.preferredJobLocation = preferredJobLocation;
    }

    public String getPreferredJobRole() {
        return preferredJobRole;
    }

    public void setPreferredJobRole(String preferredJobRole) {
        this.preferredJobRole = preferredJobRole;
    }

    public boolean isProfilePrivate() {
        return profilePrivate;
    }

    public void setProfilePrivate(boolean profilePrivate) {
        this.profilePrivate = profilePrivate;
    }

    public boolean isAllowJobAlerts() {
        return allowJobAlerts;
    }

    public void setAllowJobAlerts(boolean allowJobAlerts) {
        this.allowJobAlerts = allowJobAlerts;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

