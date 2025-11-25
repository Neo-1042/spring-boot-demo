package com.neo_1042.cruddemo.dao;

import com.neo_1042.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// Add the specialized annotation for component scanning
@Repository
public class StudentDAOImpl implements StudentDAO {

	// Define field for EntityManager
	// EntityManager is an abstract class
	private EntityManager entityManager;

	// Inject EntityManager using Constructor Injection
	// Reminder: the @Autowired annotation is optional if you only have one constructor
	// However, it is good practice to add it to the constructor injector
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	// Implement save(), don't forget the @Transactional annotation FROM SPRING
	@Override
	@Transactional
	public void save(Student theStudent)  {

		// Saves the student info to the DB
		entityManager.persist(theStudent);
	}

	@Override
	public Student findById(Integer id) {

		return entityManager.find(Student.class, id);
	}
}
