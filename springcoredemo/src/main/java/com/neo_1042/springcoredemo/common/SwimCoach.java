package com.neo_1042.springcoredemo.common;

// NOT using @Component on purpose
public class SwimCoach implements Coach {

	public SwimCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}


	@Override
	public String getDailyWorkout() {
		return "TRAIN DAILY JUST LIKE MICHAEL PHELPS";
	}
}
