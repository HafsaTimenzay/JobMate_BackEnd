package com.example.JobMatee.dto;

import com.example.JobMatee.model.Role;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RecruiterSignUpDTO {
    private String email;  // Included for signup
    private String password;  // Included for signup

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


}

