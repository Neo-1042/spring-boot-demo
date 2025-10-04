package com.neo_1042.springcoredemo.common;

import org.springframework.stereotype.Component;

// The Component Annotation from Spring marks this class as a Spring Bean
// and makes it available for dependency injection.

// Spring Beans have the default scope = SINGLETON
@Component
public class CricketCoach implements Coach {

	public CricketCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {

		return "DISCIPLINE AND TECHNIQUE WILL GRANT YOU TRUE HAPPINESS.";
	}
}
