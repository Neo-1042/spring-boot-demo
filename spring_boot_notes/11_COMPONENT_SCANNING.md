# Component Scanning

Spring will scan your classes for ```@Component``` and automatically
register the beans in the Spring container.

When you create a Spring Boot project with the _Initializr_, it
automatically generates a Java class containing the main() method.

### Main Spring Boot application class

File:
_/springcoredemo/src/main/java/com/neo_1042/springcoredemo/SpringcoredemoApplication.java_


```java
package com.neo_1042.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This annotation includes
// @EnableAutoConfiguration
// @ComponentScan (current and sub-packages)
// @Configuration (Allows extra beans or import other config classes)
@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {

        // Creates the application context
        // Registers all the beans
        // Starts the embedded server (Tomcat)
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
```

Right beneath
/springcoredemo/src/main/java/com/neo_1042/springcoredemo/

we can add packages which will be scanned by Spring Boot:

- common
- controller
- dao
- rest
- service
- security

If you want Spring Boot to scan other packages outside

```package com.neo_1042.springcoredemo;```

You can add them in the @SpringBootApplication annotation:

```java

@SpringBootApplication(
    scanBasepackages={
        "com.luv2code.util"
        ,"org.acme.cart"
        ,"edu.cmu.srs"
    }
)
public class SpringcoredemoApplication {} // ...
```