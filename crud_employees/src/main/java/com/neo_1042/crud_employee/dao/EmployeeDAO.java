package com.neo_1042.crud_employee.dao;

import com.neo_1042.crud_employee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

	List<Employee> findAll();
}
