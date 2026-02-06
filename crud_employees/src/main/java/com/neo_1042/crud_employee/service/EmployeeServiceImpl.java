package com.neo_1042.crud_employee.service;

import com.neo_1042.crud_employee.dao.EmployeeDAO;
import com.neo_1042.crud_employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;

	// EmployeeDAO injection. Constructor injection (@Autowired)
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}

	// READ all
	@Override
	public List<Employee> findAll() {

		return employeeDAO.findAll();
	}

	// READ one by id
	@Override
	public Employee findById(int id) {

		return employeeDAO.findById(id);
	}

	// CREATE or UPDATE
	@Transactional
	@Override
	public Employee save(Employee theEmployee) {

		return employeeDAO.save(theEmployee);
	}

	// DELETE by id
	@Transactional
	@Override
	public void deleteById(int id) {

		employeeDAO.deleteById(id);
	}

}
