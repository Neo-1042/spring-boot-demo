package com.neo_1042.crud_employee.rest;

import com.neo_1042.crud_employee.dao.EmployeeDAO;
import com.neo_1042.crud_employee.entity.Employee;
import com.neo_1042.crud_employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {

	private EmployeeService employeeService;

	// Quick and dirty: inject employee DAO
	@Autowired
	public EmployeeRESTController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	// Expose /employees ENDPOINT
	@GetMapping("/employees")
	public List<Employee> findAll() {

		return employeeService.findAll();
	}

	// GET by id
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);

		if (theEmployee == null) {
			throw new RuntimeException("Employee id = " + employeeId + " not found");
		}

		return theEmployee;
	}

	// CREATE with POST


	// UPDATE with PUT


	// DELETE by id with DELETE



}
