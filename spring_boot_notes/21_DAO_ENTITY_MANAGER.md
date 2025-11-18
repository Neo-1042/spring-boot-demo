# DAO = Data Access Object

A DAO is responsible for interfacing with the database.

[+] Common design pattern: DAO

| Methods |
| :---:   |
|```save()```| 
|```findById()```| 
|```findAll()```| 
|```findByLastName()```| 
|```update()```| 
|```delete()```| 
|```deleteAll()```| 

[+] Every DAO needs a JPA Entity Manager.

## JPA Entity Manager

The **Entity Manager** is the main component for 
saving/retrieving entities (DB objects).
In turn, the JPA Entity Manager needs a Data Source.

## Data Source

The Data Source defines database connection information.

[+] Both the JPA Entity Manager and the Data Source are
automatically created by Spring Boot, based on the
```application.properties``` file.

After this setup, we can autowire/inject the JPA Entity
Manager into our StudentDAO.java

### Architecture simple overview:

DAO <-> JPA Entity Manager <-> Data Source <-> DB

# What about JpaRepository?

Spring Data JPA has a JpaRepository interface, which
provides JPA database access with minimal coding.

[+] Knowing both **EntityManager** and **JpaRepository**
will help you on future projects!
(both will be covered in this course)

In simple terms:

1. **EntityManager** -> low-level control and flexibility.
You need to write custom queries, native SQL queries
or stored procedure calls.

2. **JpaRepository** -> high-level of abstracton. It provides
commonly used CRUD operations. It has additional features
such as pagination and sorting. You can generate
queries based on method names and you can create
custom queries using @Query.

You can use both in the same project, depending on the
project's needs.