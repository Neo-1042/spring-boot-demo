# Eureka Naming Server

What if the URL of a given microservice changes?
How will other components be able to talk to this microservice?

Microservices should be able to find each other, no matter
which port they are assigned to.

```mermaid
flowchart TB
    N["Eureka Naming Server"] --> A["currency-conversion"] 
    N --> B["currency-exchange"]
    N --> C["Microservice X"] 
```

If Microservice X has 5 instances running, all 5 instances
will be registered with the **Eureka Service Registry**.

Eureka knows all the current locations.

Suppose M1 wants to communicate with M2, which has 5 instances
up and running.

1. M1 asks the Load Balancer (Gateway).
2. The Load Balancer asks Eureka.
3. Eureka responds "Go to Instance 3"
4. The Gateway routes requests-responses to Instance #3

# Setting up Eureka Naming Server (Initializr)

- GroupId = com.neo_1042.microservices
- ArtifactId = naming-server

Dependencies = {Dev Tools, Actuator, Eureka Server}