# Spring Boot Actuator

### Problems:

- How to **monitor** and **manage** my application?
- How to check the **application's health**?
- How can I access **application metrics**?

## Solution: Spring Boot Actuator

### Exposes endpoints to monitor and manage your application

&#x2611; Easily get DevOps functionality 'out-of-the-box'.

&#x2611; Simply add the dependency to your POM file.

&#x2611; REST endpoints are **automatically** added to your app.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
    <!-- App monitoring and health -->
</dependency>
```

Endpoints are prefixed with: ```/actuator```, for instance:

By default, only ```/actuator/health``` is exposed:

```localhost:8080/actuator/health``` => Customizable according to your business rules!

The ```/actuator/info``` endpoint will be exposed by modifying the following:

File: src/main/resources/application.properties
```properties
management.endpoints.web.exposure.include=health,info
management.info.env.enabled=true
# Add actual information about your application
info.app.name=My Super Duper Cool Spring Boot App
info.app.description=This is very fun, actually. 2025 is shaping up to be a very productive year
info.app.version=1.0.0
```

Displays the following JSON object:
```json
{
  "app": {
    "name": "My Super Duper Cool Spring Boot App",
    "description": "This is very fun, actually. 2025 is shaping up to be a very productive year",
    "version": "1.0.0"
  }
}
```

### Some more Spring Boot Actuator endpoints

```/actuator/auditevents``` => Audit events for your application

```/actuator/beans``` => List of all beans registered in the Spring app context

```/actuator/mappings``` => List of all ```@RequestMapping``` paths.

File: src/main/resources/application.properties
```properties
# Use * to expose all endpoints
management.endpoints.web.exposure.include=*
```

## Securing the Spring Boot Actuators 

```xml
<!-- Adding security to the actuators-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

Spring Security will prompt for login.

Default username = 'user'

Default password on the console logs.

**Override default user name and password**

File: src/main/resources/application.properties
```properties
spring.security.user.name=Rafa
spring.security.user.password=tiger01
```

You can customize Spring Security for Spring Boot Actuator by linking to a
database for roles and encrypted passwords.

Exclude the ```/actuator/health``` endpoint.
```properties
management.endpoints.web.exposure.exclude=health
```