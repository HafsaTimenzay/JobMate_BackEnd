package com.example.JobMatee.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String username;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role; // ENUM to distinguish between Candidate and Recruiter

    @Column(nullable = false)
    private boolean verified; // True if email is verified

    @Column(nullable = false)
    private String fullName;

    @Column(name = "verification_token")
    private String verificationToken;

}

