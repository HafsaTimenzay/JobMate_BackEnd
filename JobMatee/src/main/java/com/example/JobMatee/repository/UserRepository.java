package com.example.JobMatee.repository;

import com.example.JobMatee.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Check if a user exists by email
    boolean existsByEmail(String email);

    // Check if a user exists by username
    boolean existsByUsername(String username);

    // Find a user by email
    Optional<User> findByEmail(String email);

    // Find a user by verification token (optional, if using tokens for verification)
    Optional<User> findByVerificationToken(String token);
}