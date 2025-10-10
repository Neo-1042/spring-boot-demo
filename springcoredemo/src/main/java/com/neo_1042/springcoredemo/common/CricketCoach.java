package com.neo_1042.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Component;
// Demo for custom init() and custom destroy()
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


import org.springframework.context.annotation.Scope;

// The Component Annotation from Spring marks this class as a Spring Bean
// and makes it available for dependency injection.

// Spring Beans have the default scope = SINGLETON
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CricketCoach implements Coach {

	public CricketCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}

	// Define custom init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("Initializing CricketCoach");
		System.out.println("Firing engines ... ");
		System.out.println(getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		return "DISCIPLINE AND TECHNIQUE WILL GRANT YOU TRUE HAPPINESS.";
	}

	// Define custom destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("About to shut down");
		System.out.println(" ... ");
		System.out.println(getClass().getSimpleName());
	}
}
