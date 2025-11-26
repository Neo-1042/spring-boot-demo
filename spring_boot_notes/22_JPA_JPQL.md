# Query Multiple Objects with Hibernate JPA-JPQL

## JPQL = JPA Query Language

Query language for retrieving objects. Similar to SQL.

[+] However, JPQL is based on **entity name** and **entity fields**.

```java
// "Student" is the name of the JPA Entity, i.e. the class name
// "FROM Student" is NOT the actual name in the SQL DB
TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

List<Student> students = the Query.getResultList();
```

### Retrieving students with lastName = 'Potter'

```java
TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName='Potter' OR firstName='Ronald'", Student.class);

List<Student> studentsRonPotter = theQuery.getResultList();
```

In summary, you can use <code>AND, OR, LIKE</code> and so on.

# JPQL - Named Parameters

```java
public List<Student> findByLastName(String theLastName) {

    TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:parName", Student.class);

    theQuery.setParameter("parName", theLastName);

    return theQuery.getResultList();
}
```

# JPQL and the SELECT clause

So far, the query examples with JPQL did not sppecified a
SELECT clause.

The Hibernate implementation is lenient (indulgente, poco severo) and allows Hibernate Query Language (HQL).

For strict **JPQL**, the **SELECT clause is mandatory**.

```java
// Strict JPQL
TypedQuery<Student> theQuery = entityManager.createQuery("SELECT s FROM Student s", Student.class);
```

```java
// Strict JPQL Example 2
TypedQuery<Student> theQuery = entityManager.createQuery("SELECT s FROM Student s WHERE s.email LIKE '%@apple.com'", Student.class);
```

# Development Process

1. Add a new method to the "StudentDAO" interface
```java
List<Student> findAll();
```

2. Implement this method in "StudentDAOImpl"
```java
@Override
public List<Student> findAll() {
    TypedQuery<Student> theQuery = entityManager.createQuery("SELECT s FROM Student s", Student.class);

    return theQuery.getResultList();
}
```

3. Update main app
```java
@Bean
public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

    return runner -> {
        queryForStudents(studentDAO);
    };
}

private void queryForStudents(StudentDAO studentDAO) {

    // Get the list of students
    List<Student> theStudents = studentDAO.findAll();

    // Display the list of students
    System.out.println("Total students so far: ");
    for (Student tmpStudent : theStudents) {
        System.out.println(tmpStudent);
    }
}
``` 