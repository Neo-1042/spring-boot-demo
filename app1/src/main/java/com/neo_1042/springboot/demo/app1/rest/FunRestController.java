package com.neo_1042.springboot.demo.app1.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// Expose a '/' endpoint that returns 'Hello, World'
	@GetMapping("/")
	public String sayHello() {
		return "Hello, World from a RESTful controller";
	}

	// Expose a new endpoint for "workout"
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 10k";
	}

	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is going to be very productive :D";
	}
}
