package com.neo_1042.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

// The Component Annotation from Spring marks this class as a Spring Bean
// and makes it available for dependency injection.
@Component
// @Lazy -> "Call me only if you really need me"
public class BaseballCoach implements Coach {

	// No-arg (no argument) constructor
	public BaseballCoach() {
		System.out.println("In Constructor: " + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {

		return "COMPA GERA LIKES BASEBALL";
	}
}
