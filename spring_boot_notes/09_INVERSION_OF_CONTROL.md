# Inversion of Control (IoC)

DEF = The approach of outsourcing the construction and managements of objects

Outsource the creation of objects.

### My App -----> Object Factory

"Give me a coach object" : Configurable objects. You can choose from:

- CricketCoach
- HockeyCoach
- BaseballCoach

A Spring container will work as an Object Factory. This Spring Container will
have 2 primary functions:

1. Create and manage objects (_Inversion of Control_)
2. Inject object dependencies (_Dependency Injection_)

### How to configure the Spring container?

- XML configuration file (legacy)
- Java Annotations (modern)
- Java Source Code (modern)

END_OF_FILE
