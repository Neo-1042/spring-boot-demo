package com.neo_1042.crud_employee.service;

import com.neo_1042.crud_employee.dao.EmployeeRepository;
import com.neo_1042.crud_employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// private EmployeeDAO employeeDAO;
	// Moving from a "manual" DAO to JpaRepository from Spring Data JPA
	private EmployeeRepository employeeRepository;

	// EmployeeRepository injection. Constructor injection (@Autowired)
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	// READ all
	@Override
	public List<Employee> findAll() {

		return employeeRepository.findAll();
	}

	// READ one by id
	@Override
	public Employee findById(int id) {
		// Refactor as a local variable
		// Optional is a different pattern that replaces having to check for nulls.
		// java.util.Optional was introduced from Java 8
		Optional<Employee> result = employeeRepository.findById(id);

		Employee theEmployee = null;

		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			throw new RuntimeException("Did not find employee");
		}

		return theEmployee;
	}

	// CREATE or UPDATE
	@Override
	public Employee save(Employee theEmployee) {

		return employeeRepository.save(theEmployee);
	}

	// DELETE by id
	@Override
	public void deleteById(int id) {

		employeeRepository.deleteById(id);
	}

}
