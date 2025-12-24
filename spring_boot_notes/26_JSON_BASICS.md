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