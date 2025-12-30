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