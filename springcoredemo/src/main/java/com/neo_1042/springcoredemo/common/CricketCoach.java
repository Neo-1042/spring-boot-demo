package com.neo_1042.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Component;

import org.springframework.context.annotation.Scope;

// The Component Annotation from Spring marks this class as a Spring Bean
// and makes it available for dependency injection.

// Spring Beans have the default scope = SINGLETON
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

	public CricketCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {

		return "DISCIPLINE AND TECHNIQUE WILL GRANT YOU TRUE HAPPINESS.";
	}
}
