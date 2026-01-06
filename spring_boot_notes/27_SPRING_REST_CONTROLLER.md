# Spring REST HelloWorld Controller

REST client (Postman) <---> REST Service (Code)

REST endpoint:
/test/hello/

## REST Web Service development process

1. Add Maven dependency for **Spring Boot Starter Web MVC**
(either in the pom.xml file directly or by using the
**Spring Initializr**)

File: pom.xml
```xml
    <!-- Add Spring Boot Starter Web MVC-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-webmvc</artifactId>
    </dependency>
```


2. Create Sring REST service using ```@RestController```

```java
@RestController
@RequestMapping("/test")
public class DemoRestController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Neo";
    }
}
```

# Create a New Service /api/students

Request Line = <code>GET</code> 

Endpoint = /api/students

The REST service will return ```List<Student>```, which
needs to be converted into JSON data.

## Student List REST API development process

1. Create POJO for the Student class

```mermaid
classDiagram
    class Student {
        -String firstName
        -String lastName
        +String getFirstName()
        +void setFirstName()
        +String getLastName()
        +void setLastName()
    }
```

2. Create Spring REST Service using ```@RestController```

File: StudentRestController.java
```java
@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // @PostConstruct is called only once
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Rodrigo","Hurtado"));
        theStudents.add(new Student("Compare","Gera"));
        theStudents.add(new Student("Emiliano", "Gonce"));
    }
    // Define endpoint for "/students"
    @GetMapping("/students")
    public List<Student> getStudents() {

        // Jackson converts List<Student> to JSON array
        return theStudents; 
    }
}
```

# Path Variables with @PathVariable

Retrieve a single student by studentId.

```GET``` /api/students/{studentId}

```java
@RestController
@RequestMapping("/api")
public class StudentRestController {

    // New endpoint
    // By default, variables 'studentId' must match
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // Access the private students list.get(index)
        return theStudents.get(studentId);
    }
}
```