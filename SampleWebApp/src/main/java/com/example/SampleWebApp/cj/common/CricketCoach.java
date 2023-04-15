package com.example.SampleWebApp.cj.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Do a daily 15 minutes workout";
	}
}