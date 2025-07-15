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

```spring initializr``` recommended **Spring Boot starters**:

- Spring Boot Starter Web
- Spring Boot Starter Security
- Spring Boot Starter Data JPA (includes Hibernate)
- Thymeleaf

Most IDEs have a dependency management/view feature to navigate
the contents of a Spring Boot Starter

## What's in the Starter?

### Eclipse IDE

- Open the pom.xml
- Select the tab "Dependency Hierarchy"
- Expand the desired starter

### IntelliJ IDE

- View > Tool Windows >  Maven Projects > Dependencies
- Select the starter and display the contents

# Spring Boot Starter Parent

Spring Boot provides a special starter with Maven defaults:

### The Parent Spring Boot Starter defines the version that will be inherited by the dependencies
```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.5.3</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```
Defines the default compiler level, UTF-8 encoding, etc.

To override a default, set as a property:
```xml
<properties>
    <java.version>17</java.version>
</properties>
```

There is no need to list individual versions for additional dependencies.
This is great for maintenance! Spring Boot makes sure all of these
versions are compatible.

Additionally, the Starter Parent provides default configuration of the
**Spring Boot plugin**:

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```

## Run your application from the command-line
```
mvn spring-boot:run
```


