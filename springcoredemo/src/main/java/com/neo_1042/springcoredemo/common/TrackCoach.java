package com.neo_1042.springcoredemo.common;

import org.springframework.stereotype.Component;

// The Component Annotation from Spring marks this class as a Spring Bean
// and makes it available for dependency injection.
@Component
public class TrackCoach implements Coach{

	@Override
	public String getDailyWorkout() {

		return "USAIN BOLT ID THE BEST";
	}
}

