package hugo.mota.microservices.mssales.controller;

import hugo.mota.microservices.mssales.dto.ProductDto;
import hugo.mota.microservices.mssales.entity.ProductEntity;
import hugo.mota.microservices.mssales.mapper.ProductMapper;
import hugo.mota.microservices.mssales.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private ProductMapper mapper;

    @GetMapping("")
    public ResponseEntity<List<ProductDto>> getAll() {
        log.info("Get all products");
        List<ProductDto> products = service.findAll().stream().map(p -> mapper.toDto(p)).collect(Collectors.toList());

        return ResponseEntity.of(Optional.of(products));
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto dto) {
        log.info("Create a product");
        ProductEntity entity = mapper.toEntity(dto);
        entity = service.create(entity);
        dto = mapper.toDto(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}
