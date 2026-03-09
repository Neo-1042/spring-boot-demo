# Spring Data REST Configs and Sorting

- By default, Spring Data REST will create endpoints based
on the **entity type**.

`... extends JpaRepository<Book, Integer>` ---> /books  
`... extends JpaRepository<Government, Integer>` ---> /governments    
`... extends JpaRepository<Cat, Integer>` ---> /cats  

We might have problems with:  
- Goose -> Geese
- Person -> People
- Syllabus -> Syllabi

What if we want to specify a different endpoint name?

## @RepositoryRestResource(path="members")

```java
@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // ...
}
```

# Pagination (page size = 20)

- By default, Spring Data REST will return the first 20 elements

- You can navigate to the different pages of data using query
parameters.

`http://localhost:8080/members?page=3`

## application.properties Available for Spring Data REST

|  Name  |  Description  |
| :---   | :---          |
| `spring.data.rest.base-path` | Base path used to expose repository resources. |
| `spring.data.rest.default-page-size` | 20 by default. |
| `spring.data.rest.max-page-size` | 50, for example. |

# Sorting

- We can sort by the property names of your entity.

`http://localhost:8080/employees?sort=lastName,desc`