package com.neo_1042.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// The Component Annotation from Spring marks this class as a Spring Bean
// and makes it available for dependency injection.

// Reminder: @Qualifier (DemoController.java) has precedence over @Primary
// You can NOT have more than one @Primary annotation

// @Lazy -> The bean will only be initilized if needed for dependency injection
@Component
@Lazy
public class TrackCoach implements Coach {


	public TrackCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {

		return "USAIN BOLT IS THE BEST";
	}
}

