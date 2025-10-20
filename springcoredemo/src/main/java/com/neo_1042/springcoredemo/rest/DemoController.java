package com.neo_1042.springcoredemo.rest;

import com.neo_1042.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

/*
* Review of steps for creating a REST endpoint with Spring Boot
* 1] Create the "Coach" interface
* 2] Create the implementation(s) of "Coach", (e.g.) named "CricketCoach" => Spring Bean
* 3] Create a controller to demo this endpoint, named "DemoController"
* 4] Inject the new Coach implementation in DemoController
*
* The @Autowired annotation tells Spring to inject a dependency
* REMINDER: setter injection is used when you have optional dependencies
*/

// Demo: Bean Scope Lifecycle: go back to SINGLETON scope
// Inject only one dependency
@RestController
public class DemoController {

	// Define a private field for the dependency to be injected
	private Coach myCoach;
	// private Coach anotherCoach;

	// Update the constructor to INJECT another Coach
	@Autowired
	public void DemoController(
			@Qualifier("aquatic") Coach theCoach
			//,@Qualifier("cricketCoach") Coach theAnotherCoach
	) {
		System.out.println("In constructor: " + getClass().getSimpleName());
		myCoach = theCoach;
		//anotherCoach = theAnotherCoach;
	}

	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {

		return myCoach.getDailyWorkout();
	}

}