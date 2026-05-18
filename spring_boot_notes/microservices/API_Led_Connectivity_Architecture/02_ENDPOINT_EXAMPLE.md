# SAPI

File = DPAVController.java

```java
@RestController
@RequestMapping("/api/dpav")
@Validated
public class DPAVController {

    private final DPAVService service;

    public DPAVController(DPAVService service) {
        this.service = service;
    }

    // READ ALL
    @GetMapping("/find-all")
    public ResponseEntity<PageResponseDto<DPAVDto>> findAll(
        @PageableDefault(page = 0, size = 50) Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    // READ by ID
    @GetMapping("/id/{hcode}/{pYear}/{pQuarter}")
    public ResponseEntity<DPAVDto> findById(@Valid @ModelAttribute DPAVIdDto id) throws IOException {
        return ResponseEntity.ok(service.findById(id));
    }

    // CREATE
    @PostMapping
    public ResponseEntity<DPAVDto> create(@Valid @ModelAttribute DPAVDto dto) throws IOException {
        return ResponseEntity.ok(service.create(dto));
    }

    // UPDATE
    @PutMapping("/id/{hcode}/{pYear}/{pQuarter}")
    public ResponseEntity<DPAVDto> update(
        @Valid @ModelAttribute DPAVIdDto id,
        @Valid @RequestBody DPAVDto dto) throws IOException {
        return ResponseEntity.ok(service.update(id, dto)); 
    }

    // DELETE
    @DeleteMapping("/id/{hcode}/{pYear}/{pQuarter}")
    public ResponseEntity<Void> delete(@Valid @ModelAttribute DPAVIdDto id) throws IOException {
        service.deleteById(id);
        // TO DO: What does this line do?
        return ResponseEntity.noContent().build();
    }

    // Custom READ
    @GetMapping("/findP")
    public ResponseEntity<PageResponseDto<DPAVDto>> findP (
        @Valid @ModelAttribute findPRequestDto findPFilterRequestDto,
        @PageableDefault(page=0, size=50) Pageable pageable
    ) {
        return new ResponseEntity<>(this.service.findP(findPFilterRequestDto, pageable), HttpStatus.OK);
    }
}
```

File = PageResponseDto.java
```java
// Java generics
public class PageResponseDto<T> {

    private List<T> content;

    private int page;
    private int size;
    private long totalElements;
    private int totalPages;

    public PageResponseDto() { }

    // All args-constructor
    // Getters and Setters
    // toString()
}
```

File = DPAVMapper.java (uses MapStruct)
```java
@Component
@Mapper(componentModel="spring")
public interface DPAVMapper extends BeanMapper<DPAVDto, DPAV> {

    DPAVMapper INSTANCE = Mappers.getMapper(DPAVMapper.class);

    // Receives entity, returns DTO
    DPAVDto toDto(DPAV e);

    // Receives DTO, returns entity
    DPAV fromDto(DPAVDto d);

    void updateFromDto(DPAVDto d, @MappingTarget DPAV e);
}
```

File = DPAVRepository.java
```java
public interface DPAVRepository extends JpaRepository<DPAV, DPAVId>, JpaSpecificationExecutor<DPAV> {
    // 
}
```