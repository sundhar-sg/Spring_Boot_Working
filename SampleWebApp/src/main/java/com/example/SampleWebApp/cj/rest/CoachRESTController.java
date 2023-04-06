package com.example.SampleWebApp.cj.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SampleWebApp.cj.common.Coach;


@RestController
public class CoachRESTController {
	private Coach myCoach;
	
	@Autowired
	public CoachRESTController(Coach theCoach) {
		myCoach = theCoach;
	}
	
	@GetMapping("/dailyWorkoutCS")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
}