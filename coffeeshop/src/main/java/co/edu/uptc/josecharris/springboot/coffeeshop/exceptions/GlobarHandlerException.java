package co.edu.uptc.josecharris.springboot.coffeeshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.edu.uptc.josecharris.springboot.coffeeshop.model.ApiError;

public class GlobarHandlerException {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiError> handExceptionNotFound(ResourceNotFoundException e){
		ApiError apiError = new ApiError(404, e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
}
