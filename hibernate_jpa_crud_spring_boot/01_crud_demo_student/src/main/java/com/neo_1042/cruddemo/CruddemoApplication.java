package com.neo_1042.cruddemo;

import com.neo_1042.cruddemo.dao.StudentDAO;
import com.neo_1042.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// From the Spring Boot Framework
	// It will get executed after the Spring Beans have been loaded.

	// DAO Implementation: Inject StudentDAO
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {

		// Create the Student.java object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Rodrigo", "Hurtado", "neo@apple.com");

		// Save the Student object
		System.out.println("Saving (persist) new student object");
		studentDAO.save(tempStudent);

		// Display ID of the saved Student
		System.out.println("New student added to database with ID = " + tempStudent.getId());
	}
}
