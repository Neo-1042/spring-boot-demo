package com.neo_1042.springcoredemo.rest;

import com.neo_1042.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

/*
* Review of steps for creating a REST endpoint with Spring Boot
* 1] Create the "Coach" interface
* 2] Create the implementation of "Coach", named "CricketCoach" => Spring Bean
* 3] Create a controller to demo this endpoint, named "DemoController"
*
* The @Autowired annotation tells Spring to inject a dependency
* If you only have one constructor, then @Autowired on constructor is optional (but recommended)
*/

@RestController
public class DemoController {

	// Define a private field for the dependency (Spring Bean)
	private Coach myCoach;

	// Define a constructor for dependency injection
	@Autowired
	public DemoController(Coach theCoach) {

		myCoach = theCoach;
	}

	// We are delegating the work of the endpoint to the Spring Bean (myCoach)
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {

		return myCoach.getDailyWorkout();
	}
}
