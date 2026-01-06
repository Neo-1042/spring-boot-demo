package com.neo_1042.mvc_demo.rest;

public class StudentNotFoundException extends RuntimeException {

	// Define 3 constructors using the super class
	public StudentNotFoundException(String message) {
		super(message);
	}

	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
	}
}
