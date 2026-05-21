# SAPI

## File = DPAVController.java

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

## File = PageResponseDto.java
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

## File = DPAVMapper.java (uses MapStruct)
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

## File = DPAVRepository.java (interface)
```java
public interface DPAVRepository extends JpaRepository<DPAV, DPAVId>, JpaSpecificationExecutor<DPAV> {
    // That's it
}
```

## File = DPAVService.java (interface)
```java
public interface DPAVService extends BaseService<DPAV, DPAVDto, DPAVId, DPAVIdDto> {

    PageResponseDto<DPAVDto> findAll(Pageable pageable);
    PageResponseDto<DPAVDto> findP(FindPRequestDto requestDto, Pageable pageable);
}
```

## File = BaseService.java
```java
public interface BaseService<E, D, EID, DID> {

    List<D> findAll() throws IOException;

    D findById(DID id) throws IOException;

    D create(D dto) throws IOException;

    D update(DID id, D dto) throws IOException;

    void deleteById(DID id) throws IOException;
}
```

## File = BaseServiceImpl.java
```java
public abstract class BaseServiceImpl<E, D, EID, DID> implements BaseService<E, D, EID, DID> {

    private JpaRepository<E, EID> repository;

    private BeanMapper<D, E> mapper;

    private String capa;
    private String serviceId;
    private String serviceName;

    private final BeanMapper<DID, EID> idmapper;

    protected BaseServiceImpl(JpaRepository<E, EID> repository) // ...
}
```

## File = DPAVServiceImpl.java
```java
@Service
public class DPAVServiceImpl extends BaseServiceImpl<DPAV, DPAVDto, DPAVId, DPAVIdDto>
    implements DPAVService {
    
    private final DPAVRepository repository;

    // NOTE: this should also have a no-arg constructor:
    public DPAVServiceImpl() {} 

    public DPAVServiceImpl(
        @Autowired DPAVRepository repository,
        @Autowired DPAVMapper mapper,
        @Autowired DPAVIdMapper idmapper,
        @Value("${spring.application.capa}") String capa,
        @Value("${spring.application.service-id}") String serviceId,
        @Value("${spring.application.name}") String serviceName) {

        super(repository, mapper, idmapper, capa, serviceId, serviceName);
        this.repository = repository;
    }

    public PageResponseDto<DPAVDto> findAll(Pageable pageable) {
        Page<DPAV> resultPage = this.repository.findAll(pageable);
        return PageMapper.toPageResponse(resultPage, super.getMapper()::toDto);
    }

    public PageResponseDto<DPAVDto> findP(FindPRequestDto requestDto, Pageable pageable) {
        Specification<DPAV> spec = Specification.<DPAV>where(CommonSpecification.equalsIfHasText("bcode", requestDto.getBCode()))
                .and(CommonSpecification.equalsIfHasText("hcode", requestDto.getHCode()))
                .and(CommonSpecification.containsIfHasText("hname", requestDto.getHName()))
                .and(DPAVSpecifications.hasPYear(requestDto.getPYear()))
                .and(CommonSpecification.notEqualsIfHasText("status", StatusCodes.DELETED));
        
        Page<DPAV> resultPage = this.repository.findAll(spec, pageable);
        return PageMapper.toPageResponse(resultPage, super.getMapper()::toDto);
    }
}
```

# PAPI = Process API Layer

File = 
```java

```
