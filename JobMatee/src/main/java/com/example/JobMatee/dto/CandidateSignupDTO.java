package com.example.JobMatee.dto;

import com.example.JobMatee.model.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
public class CandidateSignupDTO {

//     Getters and setters
    private String email;
    private String password;
    private Role role;
    private String firstname;
    private String lastname;

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    //    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    public void setFirstName(String firstname) {
//
//        this.firstname = firstname;
//    }
//
//    public void setLastName(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public String getFirstName() {
//        return firstname;
//    }
//
//    public String getLastName() {
//        return lastname;
//    }
}
