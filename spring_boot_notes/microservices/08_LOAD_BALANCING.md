# Spring Cloud Load Balancer

## Client-side Load Balanding

By substituting this line in the Proxy code, you will
make use of the load balancing features:

File = CurrencyExchangeProxy.java
```java
//@FeignClient(name="currency-exchange", url="localhost:8000")
@FeignClient(name="currency-exchange")
```

## Start a new instance of the same microservice:

```bash
# Terminal 1
mvn clean install
java -jar target/x-service-0.0.1-SNAPSHOT.jar --server.port=8000

# Terminal 2
java -jar target/x-service-0.0.1-SNAPSHOT.jar --server.port=8001
```

# Spring Cloud API Gateway

Why do we need a Spring Cloud API Gateway?

In a typical enterprise environment, we might have hundreds of
microservices that need common functionalities, such as,
authentication, authorization, logging.

If you implement the common features in each microservice, you
are replicating the code.

**API Gateway** ---> A centralized place where you can put the
common features that you want many of your microservices
to have.

**Spring Cloud Gateway** is built on top of **Spring WebFlux**
(Reactive Approach), it has the following features:

- Match routes on any request attribute.
- Define Predicates and Filters.
- Integrates with Spring Cloud Discovery Client
(Load Balancing).
- Path Rewriting.

> Every incoming request to the **proxied services**
(e.g., currency-exchange) will pass first throught the
API Gateway.

Provide cross cutting concerns like security and metrics.

# Setting Up a Spring Cloud Gateway API Service

Package Name = com.neo_1042.microservices.api-gateway

Dependencies = {Actuator, Dev Tools, Eureka Discovery Client,
**Reactive Gateway**}

> IMPORTANT: don't forget to add this load balancer dependency
to the api-gateway's pom.xml file:
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-loadbalancer</artifactId>
</dependency>
```

> Debugging Guide URL = https://github.com/in28minutes/spring-microservices-v3/blob/main/03.microservices/01-step-by-step-changes/readme.md#spring-cloud-api-gateway---step-22-to-step-25

- Enable wiretap to see more details (api-gateway):
```properties
spring.cloud.gateway.httpserver.wiretap=true
spring.cloud.gateway.httpclient.wiretap=true
```

Try adding this to the `application.properties` file if you
are having problems:

```properties
spring.application.name=api-gateway
server.port=8765
eureka.client.serviceUrl.defaultZone=http://localhost:8761/

# 1. Give the route an ID
spring.cloud.gateway.routes[0].id=currency-exchange-route

# 2. Tell it to load-balance (lb) using the Eureka service name
spring.cloud.gateway.routes[0].uri=lb://CURRENCY-EXCHANGE

# 3. Define the path pattern the Gateway should intercept
spring.cloud.gateway.routes[0].predicates[0]=Path=/currency-exchange/**
```

Reminder: most important Spring Boot dependency for an API
Gateway:  
`Reactive Gateway` (from Spring Cloud Routing).

When receiving a request, it will first fo through
the API Gateway, which will talk to the Eureka Server
and ask for the port with which the requested service
was allocated.

To enable this feature, add:
```properties
# Sometimes you will have problems because of ip-address/server
# naming resolving issues.
spring.cloud.gateway.discovery.locator.enabled=true
# Try both of this, see which one works:
spring.cloud.gateway.discovery.locator.lowerCaseServiceId=true
spring.cloud.gateway.discovery.locator.lower-case-service-id=true
```

# Custom Routes with an ApiGatewayConfiguration File

File = ApiGatewayConfiguration.java
```java
package com.neo_1042.microservices.api_gateway;
// Imports ...

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

        // If you hit the API Gateway (localhost:8765/get), you will be redirected to that specified uri
        // with those custom request headers and request parameters.
        Function<PredicateSpec, Buildable<Route>> routeFunction
            = p -> p.path("/get")
                    .filters(f -> f
                        .addRequestHeader("My Header", "MyURI")
                        .addRequestParameter("Custom Param", "Hello, World")
                    )
                    .uri("http://httpbin.org:80");

        // If you don't customize the route, then use:
        // return builder.routes().build();
        // If you need a custom route, use:
        return builder.routes()
            .route(routeFunction)
            .build();
    }
}
```

Call this with: `localhost:8765/get`