# Spring Boot Introduction

Spring Boot uses Spring behind the scenes

## The problem: building a traditional Spring application is HARD

- Which JAR dependencies do I need?
- How do I setup configuration? XML or Java?
- How do I install the server? (Tomcat, JBoss, Jetty, etc.)

## Spring Boot

&#x2611; Minimizes the amount of manual configuration

&#x2611; Performs autoconfiguration based on properties-files and JAR classpath

&#x2611; Helps to resolve dependency conflicts (Maven or Gradle)

&#x2611; Provides an embedded HTTP server

Spring initializr = https://start.spring.io

**Spring Boot includes an Embedded Server**

mycoolapp.jar => This JAR file will include the app code AND the server

Spring Boot apps can be run standalone, because they include the embedded server
```bash
java -jar mycoolapp.jar # Starts up the server
```

What happens if my manager wants to deploy applications in the traditional manner?
That is, in a **JBoss** installation, for example. So I would need the WAR file.

mycoolapp.war => Includes only the application code.

### Does Spring Boot replace Spring MVC, Spring REST ...?
No. Instead, Spring Boot actually sits on top of those technologies

Therefore, Spring Boot **does not run any faster than using Spring only**.

### SPRING INITIALIZR = https://start.spring.io

- Quickly create a starter Spring project.
- Select your dependencies
- Create a Maven or Gradle project
- Import the project into your IDE

With maven, you may need to manually add the JAR files to your
build/class path. However, Maven provides a solution like a "personal shopper".

(Avoid the SNAPSHOT versions: since they are alpha/beta versions)

## Spring Projects

_Spring Projects_ are **additional Spring modules** built on top of the core Spring Framework.
However, you should be careful to only include what you need. For example: 

- Spring Cloud
- Spring Data
- Spring Batch
- Spring Security
- Spring Web Services
- Spring LDAP