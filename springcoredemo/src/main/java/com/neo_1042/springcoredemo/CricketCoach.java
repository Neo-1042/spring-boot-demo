package com.neo_1042.springcoredemo;

import org.springframework.stereotype.Component;

// The Component Annotation from spring marks this class as a Spring Bean
// and makes it available for dependency injection.
@Component
public class CricketCoach implements Coach {

	@Override
	public String getDailyWorkout() {

		return "DISCIPLINE AND TECHNIQUE WILL GRANT YOU TRUE HAPPINESS";
	}
}
