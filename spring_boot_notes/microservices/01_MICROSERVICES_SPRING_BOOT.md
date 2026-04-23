# Udemy: Master Microservices with Spring Boot and Spring Cloud

## Course Overview

1. REST API (Spring Boot)
2. Microservices (Spring Cloud)
3. Docker
4. Kubernetes

# Web Services

A web service is a component that produces output in a format
that is consumable by other applications, regardless of their
particular technology and programming language.

W3C DEFINITION -> A web service is a software system designed
to support interoperable (not platform dependent)
machine-to-machine (or application-to-application) interaction
over a network.

## How to make web services platform independent?

We need a common language and contract to be able to communicate
with the web service, regardless of the programming language.
The most popular formats for this purpose are:
1. *.xml
2. *.json

- Request -> Input of the web service
- Response -> Output of the web service
- Message Exchange Format -> JSON, XML, etc. 
- Server or Service Provider -> Entity that provides the web service.
- Client -> Service Consumer

## SOAP vs REST Web Services

- SOAP Web Services -> Use SOAP-XML as the request and response
format. In SOAP, you have:
1. SOAP envelope
2. SOAP Header
3. SOAP Body

- REST Web Services -> Build on top of HTTP, thereby using HTTP
verbs: GET, POST, PUT, UPDATE, DELETE, etc.

# Monolith Applications

A large application connected to a single larga database.

- Minor updates need a complete re-deployment
- Tightly coupled components.
- Scalability Limitations.
- The entire app is locked on a single technology stack.

# Microservices

> Small Autonomous services that work together.
<div align="right"> - Sam Newman</div>

> "The microservice architectural style is an approach to
developing a single application as a suite of small services,
each running in its own process and communicating with
lightweight mechanisms, often an HTTP resource API.
These services are built around business capabilities and
independently deployable by fully automated deployment machinery.
There is a bare minimum of centralized management of these
services, which may be written in different programming languages
and use different data storage technologies."
<div align="right"> — James Lewis and Martin Fowler</div>

## Three Critical Focus Areas of Microservices

1. REST -> Follow REST API standards and best practices.
2. Small Units -> Independently deployable units of small services.
3. Dynamic Scaling -> You should be able to quickly 
increase/decrease the number of instances of a microservice,
regardless of how many you have.

## Movie Booking Application Example

Instead of having a large monolith application, it would be
better to separate each component of a movie booking app like so:

1. MovieService -> Movie details, schedule and availability.
2. BookingService -> Ticket booking, seat selection and
booking management.
3. PricingService -> Ticket pricing, discounts and special
offers.
4. CustomerService -> Manages customer profiles, authentication
and customer support.
5. ReviewService -> Submit reviews, ratings and comments.

# Advantages of Microservices

1. Flexibility and Innovation (new technologies).
2. Dynamic Scaling.
3. Faster Release Cycles.