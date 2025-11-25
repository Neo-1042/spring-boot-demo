package com.neo_1042.cruddemo.dao;

import com.neo_1042.cruddemo.entity.Student;

public interface StudentDAO {
	// 'public' would be redundant for interface members

	// CREATE
	void save(Student theStudent);

	// READ
	public Student findById(Integer id);
}
