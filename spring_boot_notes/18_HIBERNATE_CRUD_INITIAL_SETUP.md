# Automatic Data Source Configuration

In Spring Boot, Hibernate is the default implementation of
JPA.

- **EntityManager** is the main component for managing queries.
**Entity Manager** comes from the Jakarta Persistence API (JPA).

Based on the configurations, Spring Boot will automatically create
the beans for: **DataSource**, **EntityManager**, ...
You can then inject these into your app, for example your DAO
(Data Access Object).

Go to: Spring Initializr to add the following dependencies:

- MySQL Driver: **mysql-connector-j**
- Spring Data JPA: **spring-boot-starter-data-jpa**

Theses will be configured by Spring Boot based on the entries
on the Maven pom.xml file. 

The DB connection information will be taken from the
```application.properties``` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_tracker
spring.datasource.username=springstudent
spring.datasource.password=springstudent
```

Next up: Creating a Spring Boot - Command Line App (Woohooo)
Later in the course, we will apply this to a CRUD REST API.