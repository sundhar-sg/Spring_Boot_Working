package com.example.SampleWebApp.cj.common;

public class SwimCoach implements Coach {
	
	public SwimCoach() {
		System.out.println("In Constructor: " +getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Swim 500 meters as a warm-up!!!";
	}

}
