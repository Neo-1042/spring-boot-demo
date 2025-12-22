# Add Logging Configs to Log SQL Statements

File: application.properties
```properties
# Add logging configs to display SQL statements
logging.level.org.hibernate.SQL=debug
logging.level.org.hibernate.orm.jdbc.bind=trace
```