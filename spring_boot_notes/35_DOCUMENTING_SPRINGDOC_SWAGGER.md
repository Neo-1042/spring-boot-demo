# Documenting REST APIs with OpenAPI and Swagger

### The Problem

I don't have documentation on a given REST API. I need to
review the source code to find endpoints: `@GetMapping`, etc.,
then use Postman or `curl` to call the REST API.
This is doable, but not ideal.

### My Wish

I wish we could the the app: "At runtime, generate API
documentation, inspect API endpoints based on
Spring Configs, annotations, etc. Plus, generate a Web UI that
substitutes Postman (why?)

# Springdoc

Springdoc is a separate open-source project that generates
API documentation by inspecting the API endpoints based on
Spring Configurations, annotations, etc.

# Springdoc - Swagger Web UI

Springdoc also provides a web UI (Swagger) for accessing
endpoints,
without having to install Postman, Insomnia or curl.

# OpenAPI

OpenAPI is an industry standard format for documenting APIs.
Swagger UI is powered by **Springdoc-OpenAPI**.

# Springdoc Development Process

1. Add Maven dependency for Springdoc
(find the latest version at `www.springdoc.org`)
```xml
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.8.16</version>
    </dependency>
```

2. Access Swagger UI. Default URL:

`http://localhost:8080/swagger-ui/index.html`  
Of course, you can set up your own custom path for Swagger:

```properties
# Configure Swagger UI custom path:
springdoc.swagger-ui.path=/my-fun-ui.html
```

3. Retrieve API endpoints as JSON or YAML

- Docs for API endpoints available as JSON or YAML, useful
when integrating with other components.
- Client SDK generation, API mocking, contract testing, etc.
- JSON or YAML are language-independent, so the frontend
can be processed using Python, JS, Go, C#, etc.

### JSON docs are available at:

`http://localhost:8080/v3/api-docs`

### YAML docs are available at:

`http://localhost:8080/v3/api-docs.yaml`

Of course, you customize these:
```properties
springdoc.api-docs.path=/my-api-docs
```

Access API Docs at:
`http://localhost:8080/my-api-docs` JSON  
`http://localhost:8080/my-api-docs.yaml` YAML

# IMPORTANT:

- OpenAPI/Swagger does NOT currently work with Spring Data REST
in Spring Boot 4.

- OpenAPI/Swagger DOES work with regular `@RestController`
based projects.