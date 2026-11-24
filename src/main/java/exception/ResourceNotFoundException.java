package com.example.vanillaform.exception;

// Custom exception used when a user cannot be found
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}