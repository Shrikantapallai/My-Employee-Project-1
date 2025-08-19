package com.shri.demo.exceptonHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.shri.demo.apiResponse.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
 @ExceptionHandler
 public ResponseEntity<ApiResponse<String>>handleException(Exception ex){
	 return new ResponseEntity<>(
			 new ApiResponse<>(ex.getMessage(),false,null),HttpStatus.INTERNAL_SERVER_ERROR);
			 
 }
 
 @ExceptionHandler(ResourceNotFoundException.class)
 public ResponseEntity<ApiResponse<String>>handleResourceNotFoundException(ResourceNotFoundException ex){
	 return new ResponseEntity<>(new ApiResponse<>(ex.getMessage(),false,null),HttpStatus.NOT_FOUND);
 }
 
 @ExceptionHandler(MethodArgumentNotValidException.class)
 public ResponseEntity<ApiResponse<Map<String, String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
     Map<String, String> errors = new HashMap<>();
     ex.getBindingResult().getFieldErrors().forEach(error -> {
         errors.put(error.getField(), error.getDefaultMessage());
     });

     return new ResponseEntity<>(
             new ApiResponse<>("Validation failed", false, errors),
             HttpStatus.BAD_REQUEST
     );
 }
 
}
