# REST APIs and Web Services with Spring

- JSON
- HTTP messaging
- Installing the REST client: POSTMAN
- Develop REST APIs and Web Services with
```@RestController```
- Build a CRUD interface to the database with Spring REST.

Check out the [Spring Reference Manual](www.luv2code.com/spring-reference-manual) for a complete guide to Spring
REST development.

## Business Problem: Weather Report

Build a client app that provides the weather report for a
city.

My Weather App (client) <----> Weather Service (external)

Basic questions:

### 1. How will we connect to the weather service?

By Making REST API calls over HTTP

**REST** = **Re**presentational **S**tate **T**ransfer.
Lightweight approach for communicating between applications.

### 2. What PL will we use?

REST is language-independent. Thus, both the client
application and the server application can use ANY
programming language.

### 3. What is the required data format?

REST applications can use any data format, but you will
commonly see XML and JSON.

**JSON** = JavaScript Object Notation.

## Possible Solution to the Business Problem

- Use online Weather Service API provided by: 
openweathermap.org.

- Provide weather data via an API, which asks you to specify
latitude and longitude:
```
api.openweathermap.org/data/<apiVersion>/onecall?lat={theLatitude}&lon={theLongitude}
```

- Data is available in JSON and XML formats.

### Multiple Clients to Weather Service

- Spring MVC
- C# App
- iOS App

# More Business Problem Examples

[+] **Currency Converter App**

[+] **Movie Tickets App**

[+] **Customer Relationship Manager (CRM) App**

Salesforce Platform APIs provide programmatic access to
your organization's information.

# What do we call it?

REST API = RESTful API = REST Web Services = RESTful Web
Services = REST services = RESTful Services.

Generally, they all mean the same thing. (RESTful has a
couple more HTTP verbs)