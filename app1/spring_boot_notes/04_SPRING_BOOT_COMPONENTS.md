# Spring Boot Starters

### Which Maven dependencies do I need to get my project running?

**Spring Boot Starters** is a _curated list of Maven dependencies_ tested and verified
by the Spring Development team, thus reducing the time of configuring Maven.

### Spring MVC example

Without Spring Boot, add these to the POM XML file:
- Spring support
- Hibernate Validator
- Web template: ThymeLeaf

With Spring Boot &#x2611;
```xml
<!-- Spring Boot Starter: a collection of Maven dependencies with compatible versions-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<!-- It already contains spring-web, spring-webmvc, hibernate-validator, json, tomcat, etc... -->
```

&#x2611; Make sure you have compatible versions

```spring initializr``` recommended Spring Boot starters:

