package com.example.vanillaform.controller;

import com.example.vanillaform.dto.UserDTO;
import com.example.vanillaform.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Handles requests from the frontend
@RestController
@RequestMapping("/api/users")
public class UserController {

    // Connects the controller to the service
    private final UserService userService;

    // Gets the UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Add a new user
    @PostMapping
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    // Get all users
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get one user by ID
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Update a user
    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id,
                              @Valid @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    // Delete a user
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}