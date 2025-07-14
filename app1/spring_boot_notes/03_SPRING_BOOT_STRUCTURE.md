# Spring Boot Project Structure

Spring Boot uses the **Maven Standard Directory Structure**

### Maven Wrapper Files

```mvnw``` and ```mvnw.cmd``` allow you to run a Maven project without needing to
have Maven installed or present on your path :O

If the correct version of Maven is _NOT_ found on your computer, the wrapper files
will automatically download the correct version to run Maven.

```shell
./mvnw.sh clean compile test
```

### Spring Boot Starters

A collection of Maven dependencies necessary to run the project, such as:
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>6.0.0</version>
    </dependency>
    <dependency>
        <groupId>org.hibernate.orm</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>6.1.4.Final</version>
    </dependency>
</dependencies>
```

### application.properties

```/src/main/resources/application.properties``` is empty at the beginning.
You can add:

```
# Configure server port
server.port=8585

# Configure my properties
coach.name=George Cooper
```

This properties can be injected into your Java classes:

```java
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@Value("${coach.name}") // cool
    private String coachName; 
}
```

### Static Content ```/src/main/resources/static```

By default, Spring Boot will load static resources from 
```/src/main/resources/static```. Examples: HTML files, CSS, JS scripts, images
,PDFs, etc.

<span style="color:red">WARNING: Do **not** use the ```/src/main/webapp``` directory if your application is
packaged as a JAR.</span>

The webapp directory is tied to WAR packaging. Although this
is a standard Maven directory, most build tools will silently ignore this directory
if you generate a JAR (remember that a JAR file is better when working with Spring
Boot projects, since the JAR file already includes the app code and the server)

### Templates ```/src/main/resources/templates```

Spring Boot includes auto-configuration for the following template engines:

- FreeMarker
- ThymeLeaf
- Mustache

### Unit Tests ```/src/test/java/com/neo_1642/springboot-demo/mycoolapp/MycoolappApplicationTests.java```

