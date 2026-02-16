# HTTP PATCH Verb for Partial Updates

### Common Pitfall: Partial Update Employee

When using `PUT` to update a record, the client may only
be sending some fields and not the entire JSON, so the
fields that already were put there, are lost.

`PUT` -> Replaces the entire resource.   
`PATCH` -> Modifies only specified parts.

Benefits of `PATCH`:

1. **Efficiency** -> Reduces the bandwidth of the data traffic.
2. **Flexibility** -> Allows for multiple partial updates in
a single request.

## PATCH: Partial Update on Multiple Fields

`PATCH /api/employees/5` ---> Pass the id as a @PathVariable

```json
Request Body:
{
    "firstName" : "Daniel"
    "email" : "new_email@email.com"
}
```

```json
Response Body:
{
    "id" : 5,
    "firstName" : "Daniel",
    "lastName" : "Vega",
    "email" : "new_email@email.com"
}
```

With `PATCH`, only the new email and new first name were sent,
and only those were updated.

# PATCH: Development Process

1. Inject class: `JsonMapper`, which is a helper class in
the Jackson library for JSON processing. `JsonMapper` provides
the following support:
    - Converts Java objects <-> JSON.
    - Allows merging of JSON nodes.
    - Provides **type safety** for conversions Java <-> JSON.

File = EmployeeRestController.java  
```java
import tools.jackson.databind.json.JsonMapper;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private JsonMapper jsonMapper;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService, JsonMapper theJsonMapper) {
        employeeService = theEmployeeService;
        jsonMapper = theJsonMapper;
    }
}

```

2. Add support for `@PathMapping` request method.

3. Apply patch payload to employee.

File = EmployeeRestController.java  
```java
@PatchMapping("/employees/{employeeId}")
public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayload) {

    Employee tmpEmployee = employeeService.findById(employeeId);

    // Throw Exception if NULL
    if( tmpEmployee == null ) {
        throw new RuntimeException("Employee ID not found");
    }

    // Throw exception if request body updates contains ID
    // PK CANNOT be changed using the API
    if ( patchPayload.containsKey("id") ) {
        throw new RuntimeException("Employee ID not allowed in the request body");
    }

    // Apply the partial updates to the existing employee object
    Employee patchedEmployee = jsonMapper.updateValue(tmpEmployee, patchPayload);
    Employee dbEmployee = employeeService.save(patchedEmployee);

    return dbEmployee;
}
```

### PATCH caveats

If you have complex use cases like:
1. Deeply nested JSON entities
2. You have to add, remove, copy fields
3. Move or manipulate array elements
4. Complex transformations / data enrichments

You may want to look at the RFCs for PATCH (rfc-editor.org):

- rfc6902
- rfc7386