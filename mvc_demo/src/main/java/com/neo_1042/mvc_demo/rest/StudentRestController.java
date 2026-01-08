package com.neo_1042.mvc_demo.rest;

import com.neo_1042.mvc_demo.rest.StudentNotFoundException;
import com.neo_1042.mvc_demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;

	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student("Rodrigo", "García"));
		theStudents.add(new Student("Compare","Gera"));
		theStudents.add(new Student("Emiliano", "Gonce"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {

		return theStudents;
	}

	// Define endpoint for retrieving a single student at some index from that list
	@GetMapping("/students/{studentId}")
	public Student getStudentById(@PathVariable int studentId) {

		if((studentId < 0) || (studentId >= theStudents.size())) {
			throw new StudentNotFoundException("Student ID = " + studentId + " NOT found.");
		}

		// Retrieve student from the List<Student> by index
		return theStudents.get(studentId);
	}

}


