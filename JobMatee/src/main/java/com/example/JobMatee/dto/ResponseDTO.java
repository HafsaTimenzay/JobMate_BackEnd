package com.example.JobMatee.dto;

import lombok.Data;

@Data
public class ResponseDTO {

    private Long id;

    private String email;

    private String username;

    private String role;

    private boolean verified;
}

