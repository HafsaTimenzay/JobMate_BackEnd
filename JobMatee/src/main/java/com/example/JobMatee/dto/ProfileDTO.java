package com.example.JobMatee.dto;

import com.example.JobMatee.model.CandidateSettings;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfileDTO {
    private String firstName;
    private String lastName;
    private String jobTitle;
    private String personalWebsite;
    private String resumeUrl;
    private String city;
    private String dateOfBirth;
    private String gender;
    private String educationLevel;
    private Integer experienceYears;
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CandidateSettings toEntity() {
        CandidateSettings profileSettings = new CandidateSettings();
        profileSettings.setFirstName(firstName);
        profileSettings.setLastName(lastName);
        profileSettings.setPreferredRole(jobTitle);
        profileSettings.setPersonalWebsiteUrl(personalWebsite);
        profileSettings.setResumePath(resumeUrl);
        profileSettings.setCity(city);
        profileSettings.setDateOfBirth(LocalDate.parse(dateOfBirth));
        profileSettings.setGender(gender);
        profileSettings.setEducationLevel(educationLevel);
        profileSettings.setExperienceYears(experienceYears);
        profileSettings.setPhoneNumber(phoneNumber);
        return profileSettings;
    }
}

