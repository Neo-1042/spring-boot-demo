package com.neo_1042.crud_employee.rest;

import com.neo_1042.crud_employee.dao.EmployeeDAO;
import com.neo_1042.crud_employee.entity.Employee;
import com.neo_1042.crud_employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {

	private EmployeeService employeeService;

	private JsonMapper jsonMapper;

	// Constructor Injection for the Service and the JsonMapper
	@Autowired
	public EmployeeRESTController(EmployeeService theEmployeeService, JsonMapper theJsonMapper) {
		employeeService = theEmployeeService;
		// JsonMapper is auto-configured by Spring Boot for JSON processing
		jsonMapper = theJsonMapper;
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
	// New: @PostMapping, @RequestBody
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {

		// In case they pass an ID in JSON, set id to 0
		// This is to prevent updating, instead of creating a new employee
		theEmployee.setId(0);
		// theEmployee.setId(null); In case your field uses the wrapper class 'Integer'

		Employee dbEmployee = employeeService.save(theEmployee);

		return dbEmployee;
	}

	// UPDATE with PUT
	// New: @PutMapping
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {

		Employee dbEmployee = employeeService.save(theEmployee);

		return dbEmployee;
	}

	// (partial) UPDATE with PATCH
	// New: @PatchMapping
	// JSON DATA is passed in as a MAP of key-value pairs
	@PatchMapping("/employees/{employeeId}")
	public Employee patchEmployee(@PathVariable int employeeId,
								  @RequestBody Map<String,Object> patchPayload) {
		Employee tmpEmployee = employeeService.findById(employeeId);

		if ( tmpEmployee == null ) {
			throw new RuntimeException("Employee ID not found");
		}
		// ID should not be allowed in the payload, since PK should not be changed
		if ( patchPayload.containsKey("id") ) {
			throw new RuntimeException("Employee ID not allowed in the request body");
		}

		// This patched Employee lives only in memory so far:
		Employee patchedEmployee = jsonMapper.updateValue(tmpEmployee, patchPayload);

		// Thus, we need to persist this Employee to the DB:
		Employee dbEmployee = employeeService.save(patchedEmployee);

		return dbEmployee;
	}

	// DELETE by id with DELETE



}
