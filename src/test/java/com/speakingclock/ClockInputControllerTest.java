package com.speakingclock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.speakingclock.controller.ClockInputController;
import com.speakingclock.service.SpeakClockService;

@WebMvcTest(ClockInputController.class)
public class ClockInputControllerTest {
	@Autowired
	MockMvc mockMvc;
	@MockBean
	SpeakClockService speakClockService;
	
	@Test
	void postSpeckingClock() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/speakingClock/getTime/20:00"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	void postSpeckingClockWithException() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/speakingClock/getTime/20:88"))
				.andExpect(MockMvcResultMatchers.status().is4xxClientError());
	}
	
}
