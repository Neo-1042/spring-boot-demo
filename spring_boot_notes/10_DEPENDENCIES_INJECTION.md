# Spring Dependency Injection

## The Dependency Inversion Principle

The client delegates to another object the responsibility of providing its
dependencies. 

My_APP ------> Car Factory (this object will manage the dependencies of the
electric system, the tires, the engine, and so on). The app is delegating the
management of dependencies to the Car Factory object.

### Spring container as a dependency injection manager:

A Spring container will work as an Object Factory. This Spring Container will
have 2 primary functions:

1. Create and manage objects (_Inversion of Control_)
2. Inject object dependencies (_Dependency Injection_)

### DEMO: Coach. A DemoController wants to use a coach

- New helper: Coach > This is a dependency.

We want to inject this dependency (Coach) into our DemoController.

## Injection Types. Two recommended types

1. Constructor Injection

First choice (recommended by spring.io).
Use this when you have **required dependencies**

2. Setter Injection

Use this when you have **optional dependencies**. So, in this case, if the
dependency is not provided, your app can provide reasonable default logic.

## Spring Autowiring

For dependency injection, Spring can use autowiring to look for a class that
matches by class name or interface name. Spring will automatically inject it.
So, Spring will scan for ```@Components``` and ask "Does anyone here
implement the Coach interface?" If so, let's inject them.

### Example application. Constructor Injection

1. Define the dependency interface and class
2. Create DEMO REST Controller
3. Create a **constructor** in your class for injections
4. Add ```@GetMapping``` for the endpoint

+ Coach.java
```java
package com.neo_1042.springboot.demo.app1;

public interface Coach {
	
	String getDailyWorkout();
}
```

+ CricketCoach.java
```java
package com.neo_1042.springboot.demo.app1;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
	
	@Override
    public String getDailyWorkout() {
		return "Gym practice 16 times a month";
    }
}
```

The ```@Component``` annotation marks the class as a **Spring Bean** and makes
it a candidate for the Spring injection.
A **Spring Bean** is just a regular Java class that is managed by Spring.

+ DemoController.java
```java
package com.neo_1042.springboot.demo.app1;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class DemoController {
	
	private Coach myCoach;
	
	@Autowired
    public DemoController(Coach theCoach) {
		myCoach = theCoach;
    }
	
	@GetMapping("/dailyworkout")
    public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
    }
    
}
```

### How Spring Processes your app? Behind the scenes.

- File: Coach.java (interface)
- File: CricketCoach.java (implementation)
- File: DemoController.java (REST endpoint)

With these files, the Spring framework will handle the constructor
injection like this:

```java
// The type of the Spring Bean is actually the type of the INTERFACE
Coach theCoach = new CricketCoach();

// 'theCoach' is INJECTED into the DemoController instance
// via its constructor
// Coach theCoach is a HELPER for the actual controller.
DemoController demoController = new DemoController(theCoach);
```

However, Spring is much more than **Inversion of Control** and
**Dependency Injection**.

Spring is targeted for enterprise 'real-world' applications.
Spring provides key features such as:

- Database access and transactions
- Rest APIs and Web MVC
- Security

# Setter Injection

Inject dependencies by calling setter methods on your class.
We'll take a look into an _Autowiring_ example:

1. Inject a Coach implementation
2. Spring will scan for @Component (s)
3. Does any one implement the Coach interface?
4. If so, let's inject them!

File: DemoController.java
```java
@RestController
public class DemoController {

	private Coach myCoach;

	@Autowired
	public void setCoach(Coach theCoach) {
		myCoach = theCoach;
	}
}
```

### Setter Injection. Behind the scenes

**The Spring framework** will:

```java
Coach theCoach = new CricketCoach();

DemoController demoController = new DemoController();

// SETTER INJECTION
demoController.setCoach(theCoach);
```

We can also inject dependencies by calling **ANY** method on our
class. Simply give @Autowired:

```java
@Autowired
public void doSomeStuff(Coach theCoach) {
	myCoach = theCoach;
}
```

### Reminder of usages:

1. **Constructor Injection** => Required dependencies, recommended by
spring.io.

2. **Setter Injection** => Optional dependencies.
If the dependency is not provided, your app can provide reasonable
default logic.

## FIELD INJECTION (*Not recommended)

**Not recommended by the spring.io dev team** 

Field injection used to be popular on Spring projects, but it has
fallen out of favor because it makes the code harder to 
**unit test**.

However, you will still see it in legacy projects and old books.

**FIELD INJECTION** => Inject dependencies by setting field values
on your class directly (even private fields), accomplished by using
_Java Reflection_.

File: DemoController.java

```java
package com.neo_1042.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class DemoController {

	// Field injection demo
	@Autowired
	private Coach myCoach;

	// No need for constructors or setters
	// Not recommended, but you may still encounter it

	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
}
```