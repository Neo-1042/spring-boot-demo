package com.neo_1042.crud_employee.dao;

import com.neo_1042.crud_employee.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// When you add the @Repository annotation, Spring will automatically register
// the DAO implementation.
@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {

	private EntityManager entityManager;

	// Inject the EntityManager (Constructor injection)
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> theQuery = entityManager.createQuery("FROM employee", Employee.class);

		return theQuery.getResultList();
	}
}
