package com.example.vanillaform.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


//represents a database table
@Entity

//gives database table the name "users"
@Table(name = "users")



public class User {


@Id //uniquely identifies each user

// Automatically generates a new ID when a user is saved
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // this stores users unique id


    @NotBlank (message = "Enter name")
    @Size(max = 50, message="Name cannot exceed 50 characters")

    private String name;


    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email")
    @Column(unique = true, nullable = false)

    private String email;



    //Empty constructor needed by JPA
    public User() {
    }


    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    // Changes the user's email
    public void setEmail(String email) {
        this.email = email;
    }
}



