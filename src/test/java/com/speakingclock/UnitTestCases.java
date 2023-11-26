package com.speakingclock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.speakingclock.service.SpeakClockService;
public class UnitTestCases {
	private SpeakClockService speakClockService = new SpeakClockService();
	@Test
	void speakClockServiceTest() {
		assertEquals("It's twenty", speakClockService.converToString("20", "00").strip());
	}
	
	@Test
	void speakClockServiceTest2() {
		assertEquals("It's eight fifty", speakClockService.converToString("08", "50").strip());
	}
	
	@Test
	void speakClockServiceTestDay() {
		assertEquals("It's Midday", speakClockService.checkWhatDay("08"));
	}
}
