# Spring Dependency Injection

## The Dependency Inversion Principle

The client delegates to another object the responsibility of providing its
dependencies. 

My_APP ------> Car Factory (this object will manage the dependencies of the
electric system, the tires, the engine, and so on). The app is delegating the
management of dependencies to the Car Factory object.

### Spring container as a dependency injection manager:

A Spring container will work as an Object Factory. This Spring Container will
have 2 primary functions:

1. Create and manage objects (_Inversion of Control_)
2. Inject object dependencies (_Dependency Injection_)

### DEMO: Coach. A DemoController wants to use a coach

- New helper: Coach > This is a dependency.

We want to inject this dependency (Coach) into our DemoController.

## Injection Types

1. Constructor Injection
2. Setter Injection