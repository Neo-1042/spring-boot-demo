# REST API Design

- Who will use your API?
- How will they use your API?
- Design the API based on the requirements

## API Design Process

1. Review the API requirements:

Email from your boss - REST clients should be able to:

[+] Get a list of employees
[+] Get a single employee by ID
[+] Add a new employee
[+] Update an employee
[+] Delete an employee

i.e. full CRUD support.

2. Identify the main resource/entity (the must prominent
"noun", which in this case is "Employee")

EMPLOYEES  
REST Endpoint = <code>/api/employees</code>

3. Use HTTP methods to assign action on resource

|    CRUD action | HTTP Method | Endpoint            |
|   :------:     | :------:    | :------             |
|   CREATE       |   POST      | /api/employees      |
|   READ         |   GET       | /api/employees      |
|   READ         |   GET       | /api/employees/{employeeId}|
|   UPDATE       |   PUT       | /api/employees      |
|   DELETE       |   DELETE    | /api/employees/{employeeId}|

## ANTI-PATTERNS: Bad practices!

Do NOT include actions in the endpoint:

- /api/employeesList ---> DON'T
- /api/deleteEmployee ---> DON'T
- /api/addEmployee ---> DON'T
- /api/updateEmployee ---> DON'T

> Instead, use the HTTP methods to assign the actions!