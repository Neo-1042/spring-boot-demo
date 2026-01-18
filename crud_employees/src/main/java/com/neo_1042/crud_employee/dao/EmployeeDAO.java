package com.neo_1042.crud_employee.dao;

import com.neo_1042.crud_employee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

	// READ
	List<Employee> findAll();

	// READ by id
	Employee findById(int id);

	// CREATE or UPDATE
	Employee save(Employee theEmployee);

	// DELETE
	void deleteById(int theId);
}
