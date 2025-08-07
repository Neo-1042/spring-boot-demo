# Injecting Custom Application Properties

### Problem: You need to configure your app, no hard-coding of values

### Solution: Read from the standard Spring Boot properties file:

```src/main/resources/application.properties```

Your Spring Boot app can access properties using ```@Value```

```properties
coach.name=Mickey Mouse
team.name=The Mouse Club
```

### Inject properties into the Java classes

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

