package com.neo_1042.cruddemo;

import com.neo_1042.cruddemo.dao.StudentDAO;
import com.neo_1042.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;
import java.util.List;

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
			// createStudent(studentDAO);
			// createMultipleStudents(studentDAO);
			// createReadStudent(studentDAO);
			// readAllStudents(studentDAO);
			// readByLastName(studentDAO, "Garcia");
			// updateStudent(studentDAO, 4); // Josh
			deleteStudentById(studentDAO, 8); // Rodrigo Garcia
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

	private void createMultipleStudents(StudentDAO studentDAO) {

		// Create multiple students
		System.out.println("Creating new students");
		Student tempStudent = new Student("Rodrigo", "Hurtado", "neo@apple.com");
		Student tempStudent1 = new Student("Gerardo", "Molina", "compare@apple.com");
		Student tempStudent2 = new Student("Josh", "xd", "josh@apple.com");
		Student tempStudent3 = new Student("JuanPi", "Calderon", "eljuanpi@apple.com");

		// Save those students
		System.out.println("Saving new students ...");
		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		// Display new IDs
		System.out.println("FirstStudent has ID = " + tempStudent.getId());
		System.out.println("Second Student has ID = " + tempStudent1.getId());
		System.out.println("Third Student has ID = " + tempStudent2.getId());
		System.out.println("Fourth Student has ID = " + tempStudent3.getId());
	}

	private void createReadStudent(StudentDAO studentDAO) {

		// Create student object
		System.out.println("Creating a new student ...");
		Student tmpStudent = new Student("Alan", "Turing", "turing@machine.com");

		// Persist (save) the student
		System.out.println("Saving the student to the DB ...");
		studentDAO.save(tmpStudent);

		// Display information
		Student retrievedStudent = studentDAO.findById(tmpStudent.getId());
		System.out.println("The created student has the following information: ");
		System.out.println(retrievedStudent.toString());
	}

	private void readAllStudents(StudentDAO studentDAO) {

		// Get the list of students
		List<Student> theStudents = studentDAO.findAll();

		// Display the list of students
		System.out.println("Here is the list of all students so far: ");
		for(Student tmpStudent : theStudents) {
			System.out.println(tmpStudent);
		}
	}

	private void readByLastName(StudentDAO studentDAO, String lastName) {
		// Get all students with lastName=='Garcia'
		List<Student> studentsByLastName = studentDAO.findByLastName(lastName);

		// Display the list of Students
		System.out.println("Here is the list of all students with last name = " + lastName);
		for(Student tmpStudent : studentsByLastName) {
			System.out.println(tmpStudent);
		}
	}

	private void updateStudent(StudentDAO studentDAO, int studentId) {

		// Retrieve the student with the passed ID
		Student theStudent = studentDAO.findById(studentId);
		System.out.println("Student info with id = " + studentId + " BEFORE the update: ");
		System.out.println(theStudent);

		// Change the last name
		System.out.println("Updating the student ...");
		theStudent.setLastName("Peck");

		// Update the student's information
		studentDAO.update(theStudent);

		// Display the new information
		System.out.println("Student info with id = " + studentId + " AFTER the update: ");
		System.out.println(theStudent);
	}

	private void deleteStudentById(StudentDAO studentDAO, int studentId) {
		// Retrieve the student with the passed ID
		Student theStudent = studentDAO.findById(studentId);
		System.out.println("Deleting student with id = " + studentId);
		System.out.println(theStudent);

		// Delete the student
		studentDAO.delete(studentId);

	}
}
