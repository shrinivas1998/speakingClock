package com.speakingclock.exception;

import org.springframework.http.HttpStatus;

public class InvalidNumberException extends RuntimeException{
	HttpStatus httpStatus;
	public InvalidNumberException(String message,HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}
}
