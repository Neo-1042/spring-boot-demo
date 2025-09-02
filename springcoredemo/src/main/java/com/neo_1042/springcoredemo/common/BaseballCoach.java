package com.neo_1042.springcoredemo.common;

import org.springframework.stereotype.Component;

// The Component Annotation from Spring marks this class as a Spring Bean
// and makes it available for dependency injection.
@Component
public class BaseballCoach implements Coach{

	@Override
	public String getDailyWorkout() {

		return "COMPA GERA LIKES BASEBALL";
	}
}
