# Load Balancing

By substituting this line in the Proxy code, you will
make use of the load balancing features:

File = CurrencyExchangeProxy.java
```java
//@FeignClient(name="currency-exchange", url="localhost:8000")
@FeignClient(name="currency-exchange")
```

## Start a new instance of the same microservice:

```bash
# Terminal 1
mvn clean install
java -jar target/x-service-0.0.1-SNAPSHOT.jar --server.port=8000

# Terminal 2
java -jar target/x-service-0.0.1-SNAPSHOT.jar --server.port=8001
```