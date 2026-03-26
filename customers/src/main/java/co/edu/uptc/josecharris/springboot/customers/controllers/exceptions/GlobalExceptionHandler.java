package co.edu.uptc.josecharris.springboot.customers.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.edu.uptc.josecharris.springboot.customers.model.ApiError;

public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(ResourceNotFoundException ex) {
        ApiError error = new ApiError(404, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
