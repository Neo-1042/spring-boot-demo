# Spring Data JPA

In previous projects, we made use of the standard JPA API.
Now, we are switching to **Spring Data JPA**.

### The Problem: What if we need a DAO for another Entity?

Reminder:

```java
public interface EmployeeDAO {

    public List<Employee> findAll();
    
    public Employee findById(int theId);

    public void save(Employee theEmployee);

    public void deleteById(int theId);
}

// ...

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    // Methods implementation
}
```

So, if we need to create a DAO for:  
{Customer, Student, Product, Book, ...}  
Do we have to repeat all of the same code again?

Pattern:
```java
// Entity Type = Employee, PK = id (tbl_employee)
@Override
public Employee findById(int theId) {
    // Get the data
    Employee theData = entityManager.find(Employee.class, theId);

    // Return the data
    return theData
}
```