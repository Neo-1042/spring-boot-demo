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