package com.example.JobMatee.model;

import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;


    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "username", nullable = false, unique = true)
    private String username;


    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role; // ENUM to distinguish between Candidate and Recruiter


    @Column(name = "verified", nullable = false)
    private boolean verified; // True if email is verified

    @Column(name = "fullname", nullable = false)
    private String fullName;

    @Column(name = "verification_token")
    private String verificationToken;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getVerificationToken() {
        return verificationToken;
    }

    public void setVerificationToken(String verificationToken) {
        this.verificationToken = verificationToken;
    }
}

