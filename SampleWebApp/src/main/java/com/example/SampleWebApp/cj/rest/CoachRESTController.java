package com.example.SampleWebApp.cj.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SampleWebApp.cj.common.Coach;


@RestController
public class CoachRESTController {
	private Coach myCoach;
	
	@Autowired
	// With @Qualifier Annotation
	public CoachRESTController(@Qualifier("cricketCoach") Coach theCoach) {
		myCoach = theCoach;
	}
	
	@GetMapping("/dailyWorkoutCS")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
}