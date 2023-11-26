package com.speakingclock.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class SpeakClockService {
	
	private static Map<Integer,String> numToStr = new HashMap<Integer,String>(){{
		put(1, "one");
		put(2, "two");
		put(3, "three");
		put(4, "four");
		put(5, "five");
		put(6, "six");
		put(7, "seven");
		put(8, "eight");
		put(9, "nine");
		put(10, "ten");
		put(11, "eleven");
		put(12, "twelve");
		put(13, "thirteen");
		put(14, "fourteen");
		put(15, "fifteen");
		put(16, "sixteen");
		put(17, "seventeen");
		put(18, "eightteen");
		put(19, "nineteen");
		
	}};
	
	private static Map<Integer,String> numToStr2 = new HashMap<Integer,String>(){{
		put(2, "twenty ");
		put(3, "thrity ");
		put(4, "fourty ");
		put(5, "fifty " );
		
	}};

	public String converToString(String hour, String minute) {
		int hourInt = Integer.parseInt(hour);
		int minInt = Integer.parseInt(minute);
		String hourStr = "";
		String minStr = "";
		if(hourInt<=19) {
			hourStr = numToStr.get(hourInt);
		}else if(hourInt <=24 && hourInt >=20) {
			int str1 = hourInt%10;
			int str2 = hourInt/10;
			String last = "";
			if(str1>0) {
				last = numToStr.get(str1);
			}
			String first = numToStr2.get(str2);
			hourStr = first+last;
		}
		if(minInt<20 && minInt>0) {
			minStr = numToStr.get(minInt);
		}
		else if(minInt <60 && minInt >=20) {
			int str1 = minInt%10;
			int str2 = minInt/10;
			String last = "";
			if(str1>0) {
				last = numToStr.get(str1);
			}
			String first = numToStr2.get(str2);
			minStr = first+last;
		}
		return "It's "+hourStr+" "+minStr;
	}

	public String checkWhatDay(String hour) {
		int hrStr = Integer.parseInt(hour);
		if(hrStr >= 6 && hrStr < 18) {
			return "It's Midday";
		} else {
			return "It's Midnight";
		}
	} 
	
}
