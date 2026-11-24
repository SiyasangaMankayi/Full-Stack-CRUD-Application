
package com.example.vanillaform.service;

import com.example.vanillaform.dto.UserDTO;
import com.example.vanillaform.entity.User;
import com.example.vanillaform.repository.UserRepository;
import com.example.vanillaform.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// This class handles the application's user logic
@Service
public class UserService {

    // Gives us access to database operations
    private final UserRepository userRepository;

    // Constructor: Spring provides the repository here
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Register a new user
    public UserDTO createUser(UserDTO userDTO) {

        // Check whether the email is already registered
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        // Create a User entity using the DTO information
        User user = new User(userDTO.getName(), userDTO.getEmail());

        // Save the user in the database
        User savedUser = userRepository.save(user);

        // Convert the saved user into a DTO and return it
        return convertToDTO(savedUser);
    }

    // Get all registered users
    public List<UserDTO> getAllUsers() {

        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();

        // Convert each User into a UserDTO
        for (User user : users) {
            userDTOs.add(convertToDTO(user));
        }

        return userDTOs;
    }

    // Get one user using their ID
    public UserDTO getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return convertToDTO(user);
    }

    // Update an existing user
    public UserDTO updateUser(Long id, UserDTO userDTO) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // Check if another user already uses this email
        if (userRepository.existsByEmailAndIdNot(userDTO.getEmail(), id)) {
            throw new IllegalArgumentException("Email already exists");
        }

        // Update the user's details
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());

        // Save the updated user
        User updatedUser = userRepository.save(user);

        return convertToDTO(updatedUser);
    }

    // Delete a user
    public void deleteUser(Long id) {

        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found");
        }

        userRepository.deleteById(id);
    }

    // Convert User entity into UserDTO
    private UserDTO convertToDTO(User user) {

        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
