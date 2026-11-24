package com.example.vanillaform.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;



    @RestControllerAdvice //  Handles errors across all controllers


    public class GlobalExceptionHandler {

@ExceptionHandler(ResourceNotFoundException.class)

        public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {


    return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(ex.getMessage());


}
    // Handles invalid requests, such as duplicate emails
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBadRequest(IllegalArgumentException ex) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }




        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<String> handleValidationErrors(MethodArgumentNotValidException ex) {

            String errorMessage = ex.getBindingResult()
                    .getFieldErrors()
                    .get(0)
                    .getDefaultMessage();

            return ResponseEntity.badRequest().body(errorMessage);
        }

}

