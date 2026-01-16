package com.neo_1042.crud_employee.dao;

import com.neo_1042.crud_employee.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// When you add the @Repository annotation, Spring will automatically register
// the DAO implementation.
@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {

	private EntityManager entityManager;

	// Inject the EntityManager (Constructor injection)
	// The bean "theEntityManager" is automatically created by Spring Boot
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> theQuery = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);

		return theQuery.getResultList();
	}
}
