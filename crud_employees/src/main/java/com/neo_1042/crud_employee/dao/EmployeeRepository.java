package com.neo_1042.crud_employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo_1042.crud_employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // That's it. No need for an implementation class.
}
