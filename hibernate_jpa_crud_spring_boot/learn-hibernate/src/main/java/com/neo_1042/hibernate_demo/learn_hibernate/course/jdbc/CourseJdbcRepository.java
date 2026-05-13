package com.neo_1042.hibernate_demo.learn_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.neo_1042.hibernate_demo.learn_hibernate.course.Course;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY = """
        INSERT INTO COURSE (id, name, author) VALUES (?, ?, ?);
        """;

    public void insert(Course course) {

        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }
}
