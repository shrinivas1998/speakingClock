package com.speakingclock.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.speakingclock.exception.InvalidNumberException;
import com.speakingclock.exception.StringNotMatchingException;
import com.speakingclock.service.SpeakClockService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/speakingClock")
@AllArgsConstructor
public class ClockInputController {
	
	private SpeakClockService speakClockService;
	
	@PostMapping("/getTime/{timeInNumarical}")
	public ResponseEntity<String> speckingClock(@PathVariable String timeInNumarical) {
		boolean isInRequiredFormat = timeInNumarical.matches("^\\d{2}:\\d{2}");
		if(!isInRequiredFormat) {
			throw new StringNotMatchingException("Please provide input in the format of HH:MM"
												, HttpStatus.BAD_REQUEST);
		}
		String[] timeInNumaricalSplit = timeInNumarical.split(":");
		if(Integer.parseInt(timeInNumaricalSplit[0])<=0 || Integer.parseInt(timeInNumaricalSplit[0]) >24) {
			throw new InvalidNumberException("Provide correct time", HttpStatus.BAD_REQUEST);
		}
		if(Integer.parseInt(timeInNumaricalSplit[1])<0 || Integer.parseInt(timeInNumaricalSplit[1]) >=60) {
			throw new InvalidNumberException("Provide correct time", HttpStatus.BAD_REQUEST);
		}
		String timeInString = speakClockService.converToString(timeInNumaricalSplit[0],timeInNumaricalSplit[1]);
		return ResponseEntity.ok(timeInString);
	}
	
	@PostMapping("/getDay/{timeInNumarical}")
	public ResponseEntity<String> speckingClockDay(@PathVariable String timeInNumarical) {
		boolean isInRequiredFormat = timeInNumarical.matches("^\\d{2}:\\d{2}");
		if(!isInRequiredFormat) {
			throw new StringNotMatchingException("Please provide input in the format of HH:MM"
												, HttpStatus.BAD_REQUEST);
		}
		String[] timeInNumaricalSplit = timeInNumarical.split(":");
		if(Integer.parseInt(timeInNumaricalSplit[0])<=0 || Integer.parseInt(timeInNumaricalSplit[0]) >24) {
			throw new InvalidNumberException("Provide correct time", HttpStatus.BAD_REQUEST);
		}
		if(Integer.parseInt(timeInNumaricalSplit[1])<0 || Integer.parseInt(timeInNumaricalSplit[1]) >=60) {
			throw new InvalidNumberException("Provide correct time", HttpStatus.BAD_REQUEST);
		}
		String whatDay = speakClockService.checkWhatDay(timeInNumaricalSplit[0]);
		return ResponseEntity.ok(whatDay);
	}
	
}
