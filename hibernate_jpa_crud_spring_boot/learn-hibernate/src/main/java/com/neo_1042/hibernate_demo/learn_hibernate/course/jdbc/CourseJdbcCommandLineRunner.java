package com.neo_1042.hibernate_demo.learn_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.neo_1042.hibernate_demo.learn_hibernate.course.Course;


@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        
        repository.insert(new Course(1L, "Learn AWS NOW", "in28Minutes"));
    }
}
