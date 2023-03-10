package com.sprint1.tourmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	ResponseEntity<String> responseEntity=null;

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleInvalidUserException(Exception e) {
		responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	@ExceptionHandler(TourNotFoundException.class)
	public ResponseEntity<String> handleTourNotFoundException(Exception e){
		responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;
		
	}
	
	@ExceptionHandler(ReservationNotFoundException.class)
	public ResponseEntity<String> handleReservationNotFoundException(Exception e){
		responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;
		
	}
	
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<String> handleInvalidInputException(Exception e){
		responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;
		
	}
}
