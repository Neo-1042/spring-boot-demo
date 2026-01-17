package com.neo_1042.crud_employee.service;

import com.neo_1042.crud_employee.dao.EmployeeDAO;
import com.neo_1042.crud_employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;

	// EmployeeDAO injection. Constructor injection (@Autowired)
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}

	// findAll()
	@Override
	public List<Employee> findAll() {

		return employeeDAO.findAll();
	}
}
