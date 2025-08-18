package com.neo_1042.springboot.demo.app1.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// Injecting properties
	@Value("${iPad.color}")
	private String iPadColor;

	@Value("${iPhone.color}")
	private String iPhoneColor;

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

	@GetMapping("/apple-info")
	public String getAppleInfo() {
		StringBuilder strApple = new StringBuilder("I have a ");
		strApple.append(iPadColor);
		strApple.append(" iPad and a ");
		strApple.append(iPhoneColor);
		strApple.append(" iPhone.");

		return strApple.toString();
	}
}
