# Hibernate JPA Development Process

1. Annotate the Java Class
2. Develop Java Code to perform the database operations

\* Going forward, "JPA" will mean Hibernate throught this course.

Entity class = Java class that is mapped to a database table.
At minimum, the Entity class 
- Must be annotated with @Entity,
- Must have a public or protected no-arg constructor
- The class is allowed to have other constructors

ORM = Object Relational Mapping

<u>Refresher</u>:

If you don't declare any constructor, Java will provide a no-arg
constructor for free. However, if you declare constructors
with arguments, you **must** declare a no-arg constructor.

## Java Annotations

Step 1: Map the class to a database table.

Step 2: Map the fields to database columns.

```java
@Entity
@Table(name="student")
public class Student {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;
}
```

@Column is optional. If it is not specified, the column name will
be the same name as the Java field (not recommended).

### Primary Key Refresher

Uniquely identifies each row in a table.

Must be a UNIQUE and NOT NULL value.

### MySQL Autoincrement

```sql
CREATE TABLE student (

    id int NOT NULL AUTO_INCREMENT
    ,first_name VARCHAR(45) DEFAULT NULL
    ,last_name VARCHAR(45) DEFAULT NULL
    ,email VARCHAR(45) DEFAULT NULL
    ,PRIMARY KEY (id)
)
```

### Hibernate Identity - Primary Key

```java
@Entity
@Table(name="Student")
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
}
```

## ID Generation Strategies

| Name          | Description |
| :---:         |     ---     |
| GenerationType.AUTO | Pick an appropriate strategy for the particular DB |
| GenerationType.IDENTITY |  Assign primary keys using DB identity column |
| GenerationType.SEQUENCE | Assign PKs using a DB sequence | 
| GenerationType.TABLE | Assign PKs using an underlying DB table to ensure uniqueness |
| GenerationType.UUID |  Assign PKs using a globally unique identifier (UUID) to ensure uniqueness |

### Define your own custom generation strategy

1. Create an implementation of 
**org.hibernate.id.IdentifierGenerator**

2. Override the ```public Serializable generate()``` method.