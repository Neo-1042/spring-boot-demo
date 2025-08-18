# Injecting Custom Application Properties

### Problem: You need to configure your app, no hard-coding of values

### Solution: Read from the standard Spring Boot properties file:

```src/main/resources/application.properties```

```properties
coach.name=Mickey Mouse
team.name=The Mouse Club
```

### Inject properties into the Java classes

Your Spring Boot app can access properties using ```@Value```

```java
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController { 
	// Injecting properties
    @Value("${coach.name}")
    private String coachName;
	
	@Value("${team.name}")
    private String teamName;
	
}
```


## Setting Spring Boot Properties

Spring Boot can be configured in the ```application.properties``` file:
Server port, context path, actuator, security. 
Spring Boot has over 1000+ properties:

(www.luv2code.com/spring-boot-props) 

### Categories of Spring Boot Properties

- Core
```properties
# Log levels (severity)
logging.level.org.springframework=DEBUG
logging.level.org.hibernate=TRACE
logging.level.com.luv2code=INFO

# Log file name
logging.file.name=my-app.log
logging.file.path=/apps/my-app/logs
```

- Web
```properties
# HTTP server port (default 8080)
server.port=7070

# Context path of the app
server.servlet.context-path=/my-silly-app

# Default HTTP session time out
server.servlet.session.timetout=15m # 15 minutes

```

- Security

```properties
# Default user name and password
spring.security.user.name=admin
spring.security.user.password=topsecretxd

```

- Data

```properties
# JDBC URL of the database
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce

# Login username of the database
spring.datasource.username=db-master
spring.datasource.password=123098123098123dcsx
```

- Actuator

```properties
# Endpoints to include by name or wildcard
management.endpoints.web.exposure.include=*
management.endpoints.web.exposure.exclude=beans,mapping

# Base path for the actuator endpoints
management.endpoints.web.base-path=/actuator
```

- Integration
- DevTools
- Testing


