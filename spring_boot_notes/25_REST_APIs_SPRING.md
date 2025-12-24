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

# Spring Boot HTTP Basics

The most common use of REST is over the HTTP (Hypertext
Transfer Protocol) protocol. We can leverage the HTTP verbs
for CRUD operations:

| HTTP Method      | CRUD Operation |
| :------:         |     :------:      |
| POST |  CREATE  |
| GET  |  READ  |
| PUT  | UPDATE |
| DELETE | DELETE |

## HTTP Messages

The client (MyCRMApp) will send an HTTP Request Message to
the server (CRM REST Service), the server then will respond
with an HTTP Response Message.

### HTTP Request Message

1. Request Line -> HTTP verb.
2. Header Variables -> Request metadata.
3. Message Body -> Contents. Actual payload.

### HTTP Response Message

1. Response Line -> Server protocol and status code.
2. Header Variables -> Response metadata.
3. Message Body -> Response message. Processed payload.

## HTTP Response - Status Codes

- 1xx -> INFO
- 2xx -> SUCCESS
- 3xx -> REDIRECTION
- 4xx -> CLIENT-SIDE ERROR
- 5xx -> SERVER-SIDE ERROR

## MIME Content Types

MIME = Multipurpose Internet Mail-Extension

The message format is described by the MIME content type:
XML, JSON, etc. 

Basic syntax: ```type/sub-type```

Examples: ```text/html, text/plain, application/json,
application/xml```.

## Client Tool (curl, Insomnia, Postman)

A tool to send HTTP requests to the REST Web Service / API. 

```curl``` is a popular command-line client tool.

\* Download POSTMAN