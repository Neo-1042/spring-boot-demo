# Java Config Bean

1. Create @Configuration class.
2. Define @Bean method to configure the bean.
3. Inject bean into our controller.

File: config/SportConfig.java
```java
package com.neo_1042.springcoredemo.config;

import com.neo_1042.springcoredemo.common.Coach;
import com.neo_1042.springcoredemo.common.SwimCoach;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SportConfig {
    
    @Bean
    public Coach swimCoach() {
        return new swimCoach();
    }
}
```

File: rest/DemoController.java
```java
package com.neo_1042.springcoredemo.rest;

import com.neo_1042.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    // Inject the bean using the bean id "swimCoach"
    @Autowired
    public DemoController(@Qualifier("swimCoach") Coach theCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());

        myCoach = theCoach;
    }
}
```

## Use case for @Bean

- Using the "new" keyword, is that it?
- Why not just annotate the class with @Component?

