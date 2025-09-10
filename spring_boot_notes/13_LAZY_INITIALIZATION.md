# Introduction

By default, when your application starts, all beans are
initialized (@Component, etc.). Spring will create an instance
of each and make them available.

# Lazy Initialization (disabled by default)

Instead of creating all beans up front, we can specify **lazy
initialization**. In this way, a bean will only be initialized
in the following cases:

1. Required for **dependency injection**
2. Explicitly requested

Add the ```@Lazy```annotation to the given class.

## Global configuration for Lazy Initialization

File: application.properties
```properties
spring.main.lazy-initialization=true
```

In this way, all beans are lazy (xd), no beans are created until
needed, including ```DemoController()```.
Once we access the REST endpoint, Spring will determine
dependencies for DemoController.

### Advantages of Lazy Initialization

- Only create objects as needed
- Faster startup time if you have a large number of components

### Disadvantages of Lazy Initialization

- If you have web related components like ```@RestController```,
it will not created until requested.
- You may not discover configuration issues until too late.
- Need to make sure you have enough memory for all beans once
created.

&#x2611; Avoid the common pitfall of premature optimization.