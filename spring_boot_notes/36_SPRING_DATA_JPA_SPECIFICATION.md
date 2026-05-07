# REST Query Language with Spring Data JPA Specifications

(Source: Baeldung)

First, let's start with a "User" entity:

```java
@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private int age;

    // Getters and setters
}
```

Now, let's create a `UserSpecification` that implements the
`Specification` interface, and we're going to pass in our
own constraint to construct the actual query:

```java
// Recall the "SearchCriteria" class:
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
}

public class UserSpecification implements Specification<User> {

    private SearchCriteria criteria;

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        if(criteria.getOperation().equalsIgnoreCase(">")) {
            return builder.greaterThanOrEqualTo(
                root.<String> get(criteria.getKey(), criteria.getValue().toString()); 
            )
        } else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return builder.lessThanOrEqualTo(
                root.<String> get(criteria.getKey()), criteria.getValue().toString());
        } else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return builder.like(
                    root.<String> get(criteria.getKey()), "%"
                        + criteria.getValue() + "%");
            } else {
                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        } 
        return null;
    }
}
```

The `SearchCriteria` implementation holds a basic
representation of a constraint, and it's based on this
constraint that we're going to construct the query:

1. **key** -> firstName, lastName, age, etc.
2. **operation** -> equality, less than, etc.
3. **value** -> john, 25, email@example.com, etc.

Next, let's take a look at the `UserRepository`:

```java
public interface UserRepository 
    extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    }
```

Create a few users to have them ready when the tests run:
```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceJPAConfig.class})
@Transactional
@TransactionConfiguration
public class JPASpecificationIntegrationTest {

    @Autowired
    private UserRepository repository;

    private User userJohn;
    private User userTom;

    @Before
    public void init() {
        userJohn = new User();
        userJohn.setFirstName("John");
        userJohn.setLastName("Doe");
        userJohn.setEmail("john@doe.com");
        userJohn.setAge(26);
        
        repository.save(userJohn);
        
        userTom = new User();
        userTom.setFirstName("Tom");
        userTom.setLastName("Doe");
        userTom.setEmail("tom@doe.com");
        userTom.setAge(42);
        
        repository.save(userTom);
    }
}
```

Next, let's find a user with given both first and last name:

```java
@Test
public void givenFirstAndLastName() {
    UserSpecification spec1 = new UserSpecification(new SearchCriteria("firstName", ":", "john"));
    UserSpecification spec2 = new UserSpecification(new SearchCriteria("lastName", ":", "doe"));

    UserSpecification spec3 = new UserSpecification(new SearchCriteria("age", ">", "25"));
    UserSpecification spec4 = new UserSpecification(new SearchCriteria("lastName", ":", "Doe"));

    List<User> results = repository.findAll(Specification.where(spec1).and(spec2));

    assertThat(userJohn, isIn(results));
    assertThat(userTom, not(isIn(results)));
}
```

## `Specification.where()` Deprecated

The `Specification.where()` method in Spring Data JPA has
been deprecated since version 3.5.0 and will be removed in
version 4.0. Instead, use:

## `Specification.unrestricted()`

The recommended replacement for `Specification.where(null)` is
`Specification.unrestricted()`, avoiding the ambiguity of
`null` specifications. Example:

```java
Specification<MyEntity> spec = Specification.unrestricted();

if(someCondition) {
    spec = spec.and((root, query, builder) -> 
    builder.equal(root.get("field"), value));
}

if(anotherCondition) {
    spec = spec.and((root, query, builder) ->
    builder.like(root.get("name"), "%example%"));
}
```

### Alternative: Custom Empty Specification

At least, you need Spring Data JPA v 3.5.2 to be able
to use `Specification.unrestricted()`. In case you
only have access to older versions, use this:

```java
// This approach mimics the behavior of
// Specification.where(null) without triggering deprecation
// warnings.
Specification<MyEntity> spec = (root, query, builder) -> null;

if (someCondition) {
    spec = spec.and((root, query, builder) ->
    builder.equal(root.get("field"), value));
}
```

# Mastering Spring Data JPA Specifications (Medium)

Specifications are a part of the **Criteria API**, providing a
programmatic way to create queries. Specifications enable:

1. **Dynamic Query Generation** --> Easily construct queries
based on runtime conditions without concatenating strings or
manually constructing query criteria.

2. **Maintainability**

3. **Type Safety** --> Reduce the risk of runtime errors.

## Basic Concepts of JPA Specifications

- **Specification Interface** --> `Specification` is a simple
interface with a single method: `toPredicate()`, which converts
your specification to a JPA Predicate.
- **Root, CriteriaQuery and CriteriaBuilder** --> These are
part of the JPA Criteria API. The `Root` is a query root from
which you start the query, `CriteriaQuery` is used to
construct the query itself, and `CriteriaBuilder` is used to
define criteria and create predicates.

Example: Filtering users by their status:

```java
import org.springframework.data.jpa.domain.Specification;
// Other imports

public class UserSpecifications {

    public static Specification<User> hasStatus(String status) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), status);
    }
}
```

### Advanced Specifications: Combining Predicates

```java
Specification<User> activeUsers = UserSpecifications.hasStatus("ACTIVE");
Specification<User> usersWithName = UserSpecifications.hasName("John Doe");

Specification<User> activeJohns = Specification.where(activeUsers).and(usersWithName);
```

## Using Specifications in Repositories

Spring Data JPA repositories can be extended to support
Specifications:

```java
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    // Your query methods
}
```
Now, you can use the `findAll` method with a Specification:
```java
// findAll(spec) --> List<User>
List<User> activeJohns = userRepository.findAll(activeJohns);
```

## More Complex Queries with Specifications

Retrieve users based on multiple dynamic criteria like
age range, list of interests and account status.

```java
public static Specification<User> isWithinAgeRange(int min, int max) {
    return (root, query, criteriaBuilder) ->
        criteriaBuilder.between(root.get("age"), min, max);
}

public static Specification<User> hasInterests(List<String> interests) {
    return (root, query, criteriaBuilder) ->
        root.get("interests").in(interests);
}
```

You can then combine these with other Specifications to
create a query that precisely targets your user subset:

```java
Specification<User> eligibleForCampaign = Specification.where(
    UserSpecifications.hasStatus("ACTIVE"))
    .and(UserSpecifications.isWithinAgeRange(18, 35))
    .and(UserSpecifications.hasInterests(Arrays.asList("books", "tech")));
```

## Handling Relationships and Joins

Suppose a User has many Orders:
```java
public static Specification<User> hasMinimumOrders(int minOrders) {
    return (root, query, criteriaBuilder) -> {
        Join<User, Order> orders = root.join("orders");
        query.groupBy(root.get("id"));
        query.having(criteriaBuilder.greaterThanOrEqualTo(criteriaBuilder.count(orders), minOrders));
        return query.getRestriction();
    };
}
```

## Projections

Projections allow you to fetch only the data you need,
rather than retrieving entire entities.
This can significantly reduce memory usage and improve
query performance. Spring Data JPA supports
**dynamic projections**, and you can use them with
Specifications:
```java
public interface UserNameAndStatus {
    String getName();
    String getStatus();
}

// In your service or controller layer

// This approach retrieves only the name and status
// of the users, which can be more efficient than fetching
// entire User entities.
List<UserNameAndStatus> users = userRepository.findAll(spec, UserNameAndStatus.class);
```

## Specifications with QueryDSL

QueryDSL (Domain Specific Language) is a type-safe way
to write SQL in Java. It's more powerful and flexible
than Specifications in many ways, and you can
actually use them together.

Spring Data JPA supports integration with QueryDSL.
To do this, your **Repository** would extend:
- `QuerydslPredicateExecutor`
- `JpaSpecificationExecutor`.

## Caching (read-heavy) and Specifications

Caching is one of the most effective ways to improve
performance. Spring's caching abstraction can be used
alongside Specifications. You can annotate your
repository methods with `@Cacheable`, and Spring will handle
the caching for you. Remember, caching is most effective
for read-heavy operations with relatively stable data.

## Testing your Specifications

Testing is crucial to ensure your Specifications work
as expected. The following example uses the
`@DataJpaTest` annotation, which configures an
in-memory database for testing:
```java
@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testActiveJohns() {

        // Set up data
        User john = new User("John Doe", "ACTIVE");
        userRepository.save(john);

        // Define Specification
        Specification<User> spec = Specification.where(
            UserSpecifications.hasName("John Doe"))
            .and(UserSpecifications.hasStatus("ACTIVE"));

        // Execute query
        List<User> results = userRepository.findAll(spec);

        // Assert conditions
        assertThat(results).contains(john);
    }
}
```

# Best Practices and Considerations

1. **Index your columns** --> ensure that columns used in
frequently executed queries are indexed.
2. **Understand the Generated SQL**
3. **Use Paging and Sorting** --> Spring Data repositories
support pagination and sorting, which can help manage large
data sets and improve performance.