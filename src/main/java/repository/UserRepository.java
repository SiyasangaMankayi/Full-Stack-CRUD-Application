package com.example.vanillaform.repository;

import com.example.vanillaform.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

   // Checks if an email is already registered
    boolean existsByEmail(String email);

    // Checks if another user is using this email
    // Useful when updating an existing user
    boolean existsByEmailAndIdNot(String email, Long id);
}

