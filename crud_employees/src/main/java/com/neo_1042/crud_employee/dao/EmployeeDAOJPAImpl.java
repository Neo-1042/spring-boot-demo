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

	// READ all
	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> theQuery = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);

		return theQuery.getResultList();
	}

	// READ by id
	@Override
	public Employee findById(int theId) {
		Employee theEmployee = entityManager.find(Employee.class, theId);

		return theEmployee;
	}

	// CREATE or UPDATE (merge)
	@Override
	public Employee save(Employee theEmployee) {
		// If id==0, then save (insert). Else, update
		Employee dbEmployee = entityManager.merge(theEmployee);

		// Don't forget to return the UPDATED version
		return dbEmployee;
	}

	// DELETE
	@Override
	public void deleteById(int theId) {

		Employee theEmployee = entityManager.find(Employee.class, theId);

		entityManager.remove(theEmployee);
	}


}
