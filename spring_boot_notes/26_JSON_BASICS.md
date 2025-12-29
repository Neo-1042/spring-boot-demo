# JSON Syntax

**JSON** = JavaScript Object Notation.

Plain text that is especially formatted to be lightweight
and designed for storing and exchanging data.

JSON is language independent, not just for JavaScript.

The object members are "key" : "value" pairs delimited
by commas. The "**key**" is always delimited by double quotes.

```json
{
    "id" : 14,
    "firstName" : "Mario",
    "lastName" : "Bros",
    "active" : true,
    "courses" : null
}
```

**JSON values** can be: numbers (no quotes), strings (double
quotes), boolean (true, false), nested JSON objects, arrays,
or even ```null```.

### Nested JSON Object and Arrays

```json
{
    "id" : 14,
    "firstName" : "Mario",
    "lastName" : "Bros",
    "active" : true,
    "courses" : null,
    "address" : {
                    "street" : "100 Main St.",
                    "city" : "Philadelphia",
                    "state" : "Pennsylvania",
                    "zip" : "19103",
                    "country" : "USA"
                },
    "languages" : ["Java", "C", "C++", "bash"]
}
```

## JSON Placeholder. REST API for TESTING

Access:
[https://jsonplaceholder.typicode.com](https://jsonplaceholder.typicode.com) to access a FAKE online REST
API for TESTING and PROTOTYPING.
Try running the following JS code:
```javascript
fetch('https://jsonplaceholder.typicode.com/todos/1')
      .then(response => response.json())
      .then(json => console.log(json))
```

JSON Response:
```json
{
  "userId": 1,
  "id": 1,
  "title": "delectus aut autem",
  "completed": false
}
```
This REST endpoint returns a JSON with 10 users.
Try sending an HTTP request using POSTMAN:
```
https://jsonplaceholder.typicode.com/users
```

