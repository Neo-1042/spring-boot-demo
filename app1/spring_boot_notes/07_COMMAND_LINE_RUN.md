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
cd /path/to/spring-boot/project/app1
./mvnw package # This is the plugin working
java -jar target/app1-0.0.1-SNAPSHOT.jar # Run the app
# Simpler alternative:
./mvnw spring-boot:run # Spring Boot plugin
```

## Steps to run a Spring Boot Project on a UNIX-like system:

1. Verify Java installation:

```
echo $JAVA_HOME
java -version
```

2. Move to the root location of your project, which contains the "mvnw.sh" file

```
cd /Users/rafael1642/GIT/Projects/spring-boot-demo/app1
```

3. Package your application using the Spring Boot plugin (no need to have
the correct version of Maven installed)

```
./mvnw package # Downloads and runs Maven to generate the JAR
```

4. Run the application with a good old **Java** command:

```
java -jar target/app1-0.0.1-SNAPSHOT.jar 
```

4.b Alternatively, run everything in one command:

```
./mvnw spring-boot:run
```