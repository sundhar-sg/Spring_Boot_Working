package com.example.SampleWebApp;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class RestFrameworkDemo {
	@GetMapping("/")
	public String sayHello() {
		return "Hello World";
	}
	
	@GetMapping("/workout")
	public String workOut() {
		return "Run a Hard 5km!";
	}
}