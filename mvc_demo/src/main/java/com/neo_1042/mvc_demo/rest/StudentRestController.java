package com.neo_1042.mvc_demo.rest;

import com.neo_1042.mvc_demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	@GetMapping("/students")
	public List<Student> getStudents() {

		List<Student> theStudents = new ArrayList<>();
		theStudents.add(new Student("Rodrigo", "Hurtado"));
		theStudents.add(new Student("Compare","Gera"));
		theStudents.add(new Student("Emiliano", "Gonce"));

		return theStudents;
	}
}
