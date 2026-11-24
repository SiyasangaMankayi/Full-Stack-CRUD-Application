package com.example.vanillaform.dto;

// Carries user information between frontend and backend
public class UserDTO {

    // User information
    private Long id;
    private String name;
    private String email;

    // Empty constructor
    public UserDTO() {
    }

    // Constructor to receive all user details
    public UserDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Gets the user's ID
    public Long getId() {
        return id;
    }

    // Gets the user's name
    public String getName() {
        return name;
    }

    // Updates the user's name
    public void setName(String name) {
        this.name = name;
    }

    // Gets the user's email
    public String getEmail() {
        return email;
    }

    // Updates the user's email
    public void setEmail(String email) {
        this.email = email;
    }
}