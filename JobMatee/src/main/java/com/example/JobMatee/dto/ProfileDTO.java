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

    public CandidateSettings toEntity() {
        CandidateSettings profileSettings = new CandidateSettings();
        profileSettings.setFirstName(firstName);
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

