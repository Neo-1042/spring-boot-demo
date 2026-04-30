# Search all Categories by {code}

1. In standard REST, GET requests should not have a body.
Instead, use `@PathVariable` or `@RequestParam`.
2. DTO vs Search Criteria: if you only need the code, don't
pass a whole CategoryDto object; just the String.
3. The Specification Flow: the Service layer's job is to
build the "recipe" (Specification) and hand it to the
Repository.

## 1] Controller

Since we want the {code} to be passed as a GET parameter,
let us use `@PathVariable`. Also, include a Pageable
object so Spring can automatically handle pagination
(limit, offset, sort) from your query parameters
(e.g. ?page=0&size=10).

File = Controller.java
```java
@GetMapping("/search/{code}")
public ResponseEntity<Page<CategoryDto>> findByCode(
    @PathVariable String code,
    Pageable pageable) {
    
    return ResponseEntity.ok(service.findAllByCode(code, pageable));
}
```

## 2]Service Implementation

Think of a **Specification** as a reusable `WHERE` clause
for your SQL query.

File = CategoryServiceImpl.java

```java
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository;

    @Override
    public Page<CategoryDto> findAllByCode(String code, Pageable pageable) {

        // 1. Build the Specification
        Specification<Category> spec = (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("code"), code);
        };

        // 2. Call the repository
        Page<Category> entityPage = repository.findAll(spec, pageable);

        // 3. Convert Entity Page to DTO Page
        return entityPage.map(entity -> {
            CategoryDto dto = new CategoryDto();
            dto.setCode(entity.getCode());
            // map other fields ...
            return dto;
        });
    }
}
```

## 3] The Repository

File = CategoryRepository.java

```java
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Category> {
    // No need to write a method here;
    // JpaSpecificationExecutor provides .findAll(spec, pageable)
}
```