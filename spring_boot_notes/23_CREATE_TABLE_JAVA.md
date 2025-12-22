# Create DB Tables with JPA Hibernate

## Use Case

Automatic table generation is useful for: db integration
testing with in-memory databases.
In general, **auto generation is NOT recommended** 
for enterprise real-time projects.

[+] Corporate DBAs prefer SQL scripts for governance and
code review. The SQL scripts can be customized and
fine-tuned for complex database designs.

[+] These SQL scripts can be version-controlled.

[+] Schema Migration Tools => **Liquibase** and **Flyway**

## Usage (recommended for development and small projects)

Java code > JPA/Hibernate > SQL > Database

File: application.properties
```properties
spring.jpa.hibernate.ddl-auto=none
spring.jpa.hibernate.ddl-auto=create # All data is lost
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.hibernate.ddl-auto=update
```

```create``` -> When you run your app, JPA Hibernate will DROP tables and
then CREATE them again based on the JPA Hibernate annotations
in your Java code.

```create-drop``` -> On application shutdown, DROP all
created database tables (UNIT TESTING).

```validate``` -> Validate the database tables schema.

```update (CAREFUL)``` -> Update the database tables schema if you
add any new features as Hibernate annotations. Use this if
you want to keep the data. However, it will ALTER the
database schema based on the latest code updates. Only
use this option for basic projects.

Don't use the ```create``` option for PROD databases.
Instead, you should have DBAs run SQL scripts.