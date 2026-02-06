package com.neo_1042.crud_employee.service;

import com.neo_1042.crud_employee.entity.Employee;

import java.util.List;

public interface EmployeeService {

	// READ all
	List<Employee> findAll();

	// READ one by id
	Employee findById(int theId);

	// CREATE or UPDATE
	Employee save(Employee theEmployee);

	// DELETE
	void deleteById(int theId);
}
