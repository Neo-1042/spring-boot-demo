package com.neo_1042.mvc_demo.rest;

import com.neo_1042.mvc_demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
