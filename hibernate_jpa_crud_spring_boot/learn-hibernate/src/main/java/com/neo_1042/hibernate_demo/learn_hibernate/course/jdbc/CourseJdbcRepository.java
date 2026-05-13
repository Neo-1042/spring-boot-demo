package com.neo_1042.hibernate_demo.learn_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY = """
        INSERT INTO COURSE (id, name, author) VALUES (1, 'Learn AWS', 'in28Minutes');
        """;

    public void insert() {

        springJdbcTemplate.update(INSERT_QUERY);
    }
}
