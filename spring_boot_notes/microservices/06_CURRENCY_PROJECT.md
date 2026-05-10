# Currency Exchange Project

1. Currency Conversion Microservice.
2. Currency Exchange Microservice.

```
http://localhost:8000/currency-exchange/from/USD/to/MXN
http://localhost:8000/currency-exchange/from/USD/to/MXN/quantity/10
```

<u>Project Dependencies</u>:

1. Spring Web
2. Spring Boot Dev Tools
3. Config Client
4. Spring Boot Actuator

### application.properties (Reminder)

```properties
spring.application.name=currency-exchange
spring.config.import=optional:configserver:http://localhost:8888
server.port=8000
```

### Currency Exchange Service

URL -> `http://localhost:8000/currency-exchange/from/USD/to/INR`

Response Structure:

```json
{
    "id" : 10001,
    "from" : "USD",
    "to" : "INR",
    "conversionMultiple": 65.00,
    "environment" : "8000 instance-id"
}
```

### Currency Conversion Service

URL -> `http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10`

Response Structure:

```json
{
    "id" : 10001,
    "from" : "USD",
    "to" : "INR",
    "quantity" : 10,
    "conversionMultiple": 650.00,
    "environment" : "8000 instance-id"
}
```