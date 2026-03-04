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
Do we have to repeat all of the same code again???

Pattern for creating DAOs:
```java
// Entity Type = Employee, PK = id (tbl_employee)
@Override
public Employee findById(int theId) {
    // Get the data
    Employee theData = entityManager.find(Employee.class, theId);

    // Return the data
    return theData;
}
```

# My Wish

I wish I could tell Spring:

- Create a DAO for me.
- Plug in my Entity type and a PK (Primary Key).
- Give me all of the basic CRUD features.

```
Entity = BOOK, CUSTOMER, PRODUCT, ...
PK = Integer

findAll()
findById()
save()
deleteById()
...
```

## Spring Data JPA is the solution!

> More than 70% reduction in code. More abstraction.
Less errors.

- Spring Data JPA provides the interface: `JpaRepository`
- Exposes the DAO methods (some by inheritance from parents)

Documentation =>
[www.luv2code.com/jpa-repository-javadoc](www.luv2code.com/jpa-repository-javadoc)

# Development Process

1. Extend the `JpaRepository` interface:

```java
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // That's it!
}

// There is NO NEED for an implementation class.
```

2. Use your Repository in your app.

```java
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    // Constructor injection
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    // This is one of the methods that we get "for free",
    // By simply extending the JpaRepository<> interface
    @Override
    public List<Employee> findAll() {

        return employeeRepository.findAll();
    }
}
```

## Spring Data JPA Advanced Features

- Extending and adding custom queries with JPQL.
- Query Domain Specific Language (Query DSL)
- Defining custom methods (lower-level coding)

# Migrate from Manual JPA to JpaRepository

1. Delete all DAOs from the dao package (not the actual folder)
2. Substitute this by the "EmployeeRepository.java" interface,  
extending "JpaRepository<Employee,Integer>"

3. At the service layer, substitute "EmployeeDAO" to
"EmployeeRepository", including all of the calls to the DAO.

4. Remove the `@Transactional` annotations in the 
"EmployeeServiceImpl.java" file, since `JpaRepository`
provides this functionality.

5. Refactor all necessary code that show errors:
`You cannot convert Optional<Employee> to Employee`, by doing:

```java
// Optional was introduced from Java 8
import java.util.Optional;

@Override
public Employee findById(int id) {
    // Refactor as a local variable
    // Optional is a different pattern that replaces having to check for nulls.
    // java.util.Optional was introduced from Java 8
    Optional<Employee> result = employeeRepository.findById(id);

    Employee theEmployee = null;

    if (result.isPresent()) {
        theEmployee = result.get();
    } else {
		throw new RuntimeException("Did not findemployee");
	}
    return theEmployee;
}
```