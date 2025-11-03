# Command Line App with Spring Boot

file: CrudDemoApplication.java
```java
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(String[] args) {

        // Lambda expression
        return runner -> {
            System.out.println("Hello, world from the " + getClass().getSimpleName());
        };
    }
}
```
