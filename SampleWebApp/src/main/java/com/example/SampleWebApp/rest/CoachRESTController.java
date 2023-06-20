package com.example.SampleWebApp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SampleWebApp.cj.common.Coach;


@RestController
public class CoachRESTController {
	private Coach myCoach;
	private Coach anotherCoach;
	
	@Autowired
	// With @Qualifier Annotation
	public CoachRESTController(@Qualifier("swimCoach") Coach theCoach) {
		myCoach = theCoach;
	}
	
	@GetMapping("/dailyWorkoutCS")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
	
	@GetMapping("/checkCS")
	public String check() {
		return "Comparing Bean Instances: " +(myCoach == anotherCoach); 
	}
}