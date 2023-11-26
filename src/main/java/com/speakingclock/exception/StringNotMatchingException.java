package com.speakingclock.exception;

import org.springframework.http.HttpStatus;

public class StringNotMatchingException extends RuntimeException{
	HttpStatus httpStatus;
	public StringNotMatchingException(String message,HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}
}
