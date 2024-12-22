package com.example.JobMatee.dto;

import com.example.JobMatee.model.CandidateSettings;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfileDTO {
    private String fullName;
    private String jobTitle;
    private String personalWebsite;
    private String resumeUrl;
    private String nationality;
    private String dateOfBirth;
    private String gender;
    private String educationLevel;
    private Integer experienceYears;
    private String biography;
    private String phoneNumber;
    private String location;

    public CandidateSettings toEntity() {
        CandidateSettings profileSettings = new CandidateSettings();
        profileSettings.setFullName(fullName);
        profileSettings.setJobTitle(jobTitle);
        profileSettings.setPersonalWebsite(personalWebsite);
        profileSettings.setResumePath(resumeUrl);
        profileSettings.setNationality(nationality);
        profileSettings.setDateOfBirth(LocalDate.parse(dateOfBirth));
        profileSettings.setGender(gender);
        profileSettings.setEducationLevel(educationLevel);
        profileSettings.setExperienceYears(experienceYears);
        profileSettings.setBiography(biography);
        profileSettings.setPhoneNumber(phoneNumber);
        profileSettings.setLocation(location);
        return profileSettings;
    }
}

