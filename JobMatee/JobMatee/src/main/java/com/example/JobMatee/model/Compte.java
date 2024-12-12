package com.example.JobMatee.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Comptes")
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(nullable = false)
    private String accountType; // Additional account details if required
}