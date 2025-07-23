# Spring Boot Dev Tools

**Problem**: whenever you make changes in the source code, 
you have to manually restart your application.

**Solution**: ```spring-boot-devtools```

&#x2611; Automatically restarts your application when code is updated

&#x2611; Simply add the dependency to your POM file:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <!-- Automatically restarts your application when code is updated -->
</dependency>
```


**Note for IntelliJ:** you need to set 2 additional configurations for the Community Edition
version:

Preferences > Build, Execution, Deployment > Compiler > **Build Project Automatically**

Preferences > Advanced Settings > **Allow auto-make to start**

You're all set &#x2611;