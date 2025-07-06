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
}
