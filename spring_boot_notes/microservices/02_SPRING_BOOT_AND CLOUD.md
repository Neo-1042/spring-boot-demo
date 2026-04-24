## Spring Boot

First of all, we already know that Spring Boot enables rapid
development of REST APIs.

## Spring Cloud

**Spring Cloud** is a set of projects (umbrella project)
that provide essential microservice needs, for example:

1. Centralized Configuration -> Central GIT repository.
2. Load Balancing -> Dynamically distribute requests across
active instances of microservices.
3. Service Discovery -> Naming server (for example, Eureka) to
enable automatic discovery.
4. Distributed Tracing -> TRace requests across microservices.
5. Edge Server -> Single Entry Point: implement common
features like authentication (for example, 
Spring Cloud Gateway).
6. Fault Tolerance -> Ensure that failure in one microservice
does NOT cascade and make other microservice to fail.

## Docker

Solution for consistently deploy microservices, regardless
of the programming language and the environment.

## Kubernetes

Orchestrate thousands of microservices with advanced
features (Service Discovery, Load Balancing, Release
Management, ...).

# Centralized Configuration: Spring Cloud Config Server

- DEV > UAT > PROD
- External Services
- Database
- Queue



