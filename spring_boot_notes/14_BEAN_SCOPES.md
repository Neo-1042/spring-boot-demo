# Lifecycle (Scope) of Beans

- How long does the bean live?
- How many instances are created?
- How is the bean shared?

By default, all beans use the scope: **singleton pattern**.
That is, the
Spring Container creates <u>only one instance of the 
bean</u>,
this bean is <u>cached in memory</u>, and all dependency
injections for the bean will <u>reference the SAME bean</u>.

### Singleton example (Spring Boot)

File: /rest/DemoController.java
```java
@RestController
public class DemoController{

    private Coach myCoach;
    private Coach anotherCoach;

    // By default, these two beans point to the same instance
    @Autowired
    public DemoController(
        @Qualifier("cricketCoach") Coach theCoach,
        @Qualifier("cricketCoach") Coach theAnotherCoach
    ) {
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }
}
```

## Explicitly Specify Bean Scope

File: common/CricketCoach.java

```java
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CricketCoach implements Coach {
    // ...
}
```

### Additional Spring Bean Scopes

1. SINGLETON > Create a single shared instance of the bean (default).
2. PROTOTYPE > Creates a new bean instance for each container request.
3. REQUEST > Scoped to an HTTP web **request**. Only for web apps.
4. SESSION > Scoped to an HTTP web **session**. Only for web apps.
5. APPLICATION > Scoped to a web app ServletContext. Only for web apps.
6. WEBSOCKET > Scoped to a web socket. Only for web apps.

## Prototype Scope Example

A new object instance is created for each injection.

File: common/CricketCoach.java
```java
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {
    // ...
}
```

## Prototype Scope implementation. How to check scope

File: rest/DemoController.java
```java
@RestController
public class DemoController {

    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(
        @Qualifier("cricketCoach") Coach theCoach,
        @Qualifier("cricketCoach") Coach theAnotherCoach
    ) {
        myCoach = theCoach;
        anotherCoach = theAnotherCoach
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: myCoach==anotherCoach,"
            + (myCoach == anotherCoach);
        // TRUE for SINGLETON
        // FALSE for PROTOTYPE
    }
}
```
