package com.app.exc_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.custom_exceptions.InvalidJsonException;
import com.app.dto.ApiResponse;

@ControllerAdvice // Mandatory cls level annotation to tell SC : following is global exc handler
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


	
	@ExceptionHandler(InvalidJsonException.class)
	public ResponseEntity<?> handleInvalidJsonException(InvalidJsonException e) {
		System.out.println("in handle res not found...");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
	}
	//for all remaining excs : add global exc handling method
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleRuntimeException(RuntimeException e) {
		e.printStackTrace();
		System.out.println("in handle run time exc.."+e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
	}
	

}
