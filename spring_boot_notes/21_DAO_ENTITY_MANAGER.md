# DAO = Data Access Object

A DAO is responsible for interfacing with the database.

[+] Common design pattern: DAO

| Methods |
| :---:   |
|```save()```| 
|```findById()```| 
|```findAll()```| 
|```findByLastName()```| 
|```update()```| 
|```delete()```| 
|```deleteAll()```| 

[+] Every DAO needs a JPA Entity Manager.

## JPA Entity Manager

The **Entity Manager** is the main component for 
saving/retrieving entities (DB objects).
In turn, the JPA Entity Manager needs a Data Source.

## Data Source

The Data Source defines database connection information.

[+] Both the JPA Entity Manager and the Data Source are
automatically created by Spring Boot, based on the
```application.properties``` file.

After this setup, we can autowire/inject the JPA Entity
Manager into our StudentDAO.java

### Architecture simple overview:

DAO <-> JPA Entity Manager <-> Data Source <-> DB

# What about JpaRepository?

Spring Data JPA has a JpaRepository interface, which
provides JPA database access with minimal coding.

[+] Knowing both **EntityManager** and **JpaRepository**
will help you on future projects!
(both will be covered in this course)

In simple terms:

1. **EntityManager** -> low-level control and flexibility.
You need to write custom queries, native SQL queries
or stored procedure calls.

2. **JpaRepository** -> high-level of abstracton. It provides
commonly used CRUD operations. It has additional features
such as pagination and sorting. You can generate
queries based on method names and you can create
custom queries using @Query.

You can use both in the same project, depending on the
project's needs.

# Step by Step DAO Implementation

1. Define DAO interface.
```java
import com.neo_1042.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);
}
```

2. Define DAO implementation.
3. Inject the EntityManager.

File: StudentDAOImpl.java
```java
import com.neo_1042.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

// Specialized annotation, sub-annotation of @Component
@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    // Inject the Entity Manager
    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    // Spring handles the transaction
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }
}

```

# Spring @Transactional

Spring provides an ```@Transactional``` annotation, which
will automatically **begin and end a transaction** for
your JPA code. (BEGIN TRANSACTION; COMMIT; ROLLBACK;)

# Specialized Annotation for DAOs: @Repository

::: mermaid
graph TD;
    A["@Component"]-->B["@RestController"];
    A-->C["@Repository"];
    A-->D[""Others]"";
:::

When you add the ```@Repository``` annotation, Spring will
automatically register the DAO implementation.
Spring also provides translation of any JDBC related
exceptions.

4. Update main app.

File: CruddemoApplication.java
```java
package com.neo_1042.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main (String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {

        // Create the Student object
        System.out.println("Creating new Student object ...");
        Student tempStudent = new Student("Rodrigo", "Hurtado", "rod@apple.com");

        // Save the Student object
        System.out.println("Saving the Student object ...");
        studentDAO.save(tempStudent);

        // Display id of saved student
        System.out.println("Saved student with id = " + tempStudent.getId());
    }
}
```