# Hibernate

Hibernate is an implementation of the JPA specification.
It is a framework for persisting Java objects in a
database.

[https://hibernate.org](https://hibernate.org)

JAVA APP <-> HIBERNATE <-> SQL DB

Hibernate has the following advantages:

[+] It handles all of the low-level SQL.

[+] Minimizes the amount of JDBC (Java Database
Connectivity) code you have to develop.

[+] Provides the ORM (Object-Relational Mapping)

All you need to do is define the mapping between the
Java class (DAO) and its associated database table.

To set up this mapping, you can use:

- XMLs
- Some other configuration file
- @Annotations

# JPA = Jakarta Persistence API

Previously known as Java Persistence API.
It's a standard API **specification**
for Object-Relational Mapping (ORM).
JPA defines a set of interfaces and requires an actual
implementation to be usable.

[*] *EclipseLink* is another JPA implementation

[+] By having a standard API, you are not locked to any
vendor's implementation, so you can easily write portable
and flexible code, so that if vendor ABC stops supporting
your JPA implementation, you can switch to vendor XYZ.

A project example would be to switch from EclipseLink
------> Hibernate.

## Save and Retrieve a Java Object with JPA

```java
// Create the Java Object
Student theStudent = new Student("Paul", "Doe", "paul@gmail.com");

// The EntityManager is a special JPA helper object
entityManager.persist(theStudent);

// JPA will take the Java object, translate it into SQL 
// code, and then INSERT it into the corresponding table.

// Retrieve the recently created object from the DB
int desiredId = 100;
Student myStudent = entityManager.find(Student.class, desiredId);
System.out.println("Retrieved student: " + myStudent);
```

### In the OLD days of JDBC, you would have to manually write the SQL code.

## Querying for Java Objects

```java
TypedQuery<Student> studentList = entityManager.createQuery(
    " from Student", Student.class
);

List<Student> listStudents = theQuery.getResultList();
```

## Bonus: How does Hibernate and JPA relate to JDBC?

Hibernate JPA actually uses JDBC for all database
communications. Therefore, Hibernate is actually an extra
abstraction layer.