# Java JSON Data Binding (mapping, serialization, marshalling)

Data binding is the process of converting JSON data to
a Java POJO (Plain Old Java Object).

JSON <------> Java POJO

## JSON Data Binding with Jackson

[+] Spring actually uses the **Jackson Project** behind the
scenes. Jackson handles the data binding between JSON
and the POJOs.

[+] Spring Boot Starter Web already includes **Jackson**.

[+] By default, Jackson will call the appropriate
getter or setter method.

JSON ------> POJO, Jackson will call the POJO's setter
methods.

POJO ------> JSON, Jackson will call the POJO's getter
methods to create or update the corresponding JSON.

### Spring and Jackson Support

When building Spring REST applications, Spring will
automatically handle Jackson integration.

[+] Any JSON data being passed to the REST controller is
converted to a POJO.

[+] Any POJO being returned from the REST controller
is converted to JSON.

