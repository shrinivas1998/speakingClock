package com.speakingclock.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.speakingclock.dto.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> exception(Exception exception, WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), 
				exception.getMessage(), 
				webRequest.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(StringNotMatchingException.class)
	public ResponseEntity<ErrorDetails> stringNotmatching(StringNotMatchingException exception, WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), 
				exception.getMessage(), 
				webRequest.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(InvalidNumberException.class)
	public ResponseEntity<ErrorDetails> InvalidNumberException(InvalidNumberException exception, WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), 
				exception.getMessage(), 
				webRequest.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
}
