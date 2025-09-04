package com.neo_1042.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// The Component Annotation from Spring marks this class as a Spring Bean
// and makes it available for dependency injection.

// Reminder: @Qualifier (DemoController.java) has precedence over @Primary
// You can NOT have more than one @Primary annotation
@Component
@Primary
public class TrackCoach implements Coach{

	@Override
	public String getDailyWorkout() {

		return "USAIN BOLT IS THE BEST";
	}
}

