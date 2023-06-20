package com.example.SampleWebApp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SampleWebApp.cj.common.Coach;


@RestController
public class CoachRESTController2 {
	private Coach myCoach;
	private Coach anotherCoach;
	
	@Autowired
	// With @Qualifier Annotation
	public CoachRESTController2(Coach theCoach, Coach theAnotherCoach) {
		myCoach = theCoach;
		anotherCoach = theAnotherCoach;
	}
	
	@GetMapping("/dailyWorkoutCRC2")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
	
	@GetMapping("/checkCRC2")
	public String check() {
		return "Comparing Bean Instances: " +(myCoach == anotherCoach); 
	}
}