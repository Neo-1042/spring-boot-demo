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