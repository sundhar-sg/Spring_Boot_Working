package com.example.SampleWebApp.cj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.SampleWebApp.cj.common.Coach;
import com.example.SampleWebApp.cj.common.SwimCoach;

@Configuration
public class SportConfig {

	@Bean
	public Coach swimCoach() {
		return new SwimCoach();
	}
}