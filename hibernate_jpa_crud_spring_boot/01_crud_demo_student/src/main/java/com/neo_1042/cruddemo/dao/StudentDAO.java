package com.neo_1042.cruddemo.dao;

import com.neo_1042.cruddemo.entity.Student;
import java.util.List;

public interface StudentDAO {
	// 'public' would be redundant for interface members

	// CREATE
	void save(Student theStudent);

	// READ
	Student findById(Integer id);

	// Multiple READs
	List<Student> findAll();

	// READ by lastName
	List<Student> findByLastName(String theLastName);

	// UPDATE
	void update(Student theStudent);

	// DELETE
	void delete(Integer id);

	// DELETE ALL
	int deleteAll();

}
