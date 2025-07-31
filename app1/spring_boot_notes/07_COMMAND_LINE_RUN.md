# Running Spring Boot from the Command Line (nice)

&#x2611; No need to have IDE open or running.

&#x2611; Since we're using Spring Boot, the **server is already embedded in our
JAR file**, so there is no need to have a separate server installed/running.

&#x2611; Spring Boot apps are self-contained.

### Option 1: Good-old java command

```java -jar mycoolapp.jar```

### Option 2: Use Spring Boot Maven plugin

```mvnw spring-boot:run```

Every Spring Boot project includes the scripts:

- **mvnw(.sh)** (for Linux/macOS)
- **mvnw.cmd** (Windows)

Running these scripts allows you to build the project without having Maven
installed or present on your path.

When the right version of Maven is not found, then this script is run and it automatically
downloads the correct version of Maven.

If you have the correct version of Maven installed, then simply run:
```
mvn clean compile test
```

Recall that the Spring Initializr added the plugin:
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```
Which you can use to package executable JAR or WAR files.

```bash
./mvnw package # Spring Boot plugin
./mvnw spring-boot:run # Spring Boot plugin
```