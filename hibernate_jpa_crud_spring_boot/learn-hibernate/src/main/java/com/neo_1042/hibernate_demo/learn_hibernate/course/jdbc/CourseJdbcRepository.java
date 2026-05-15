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

    private static String DELETE_QUERY_ID = """
            DELETE FROM COURSE WHERE ID = ?;
            """;

    public void insert(Course course) {

        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteCourseById(int id) {

        // Remember, this 'update' applies to CRUD operations, since it doesn't know about the String sql passed
        springJdbcTemplate.update(DELETE_QUERY_ID, id);
    }
}
