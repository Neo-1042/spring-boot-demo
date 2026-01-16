package com.neo_1042.crud_employee.rest;

import com.neo_1042.crud_employee.dao.EmployeeDAO;
import com.neo_1042.crud_employee.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {

	private EmployeeDAO employeeDAO;

	// Quick and dirty: inject employee DAO
	public EmployeeRESTController(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}

	// Expose /employees ENDPOINT
	@GetMapping("/employees")
	public List<Employee> findAll() {

		return employeeDAO.findAll();
	}

}
