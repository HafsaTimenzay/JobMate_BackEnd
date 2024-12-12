package com.example.JobMatee.dto;

import lombok.Data;

@Data
public class UserSignupDTO {

    private String fullName;

    private String username;

    private String email;

    private String password;

    private String role;
}
