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