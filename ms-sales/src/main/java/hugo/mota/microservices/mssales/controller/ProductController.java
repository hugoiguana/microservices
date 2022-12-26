package hugo.mota.microservices.mssales.controller;

import hugo.mota.microservices.mssales.dto.ProductDto;
import hugo.mota.microservices.mssales.entity.ProductEntity;
import hugo.mota.microservices.mssales.mapper.ProductMapper;
import hugo.mota.microservices.mssales.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private ProductMapper mapper;

    @GetMapping("")
    public ResponseEntity<List<ProductDto>> getAll() {

        List<ProductDto> products = service.findAll().stream().map(p -> mapper.toDto(p)).collect(Collectors.toList());

        return ResponseEntity.of(Optional.of(products));
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto dto) {

        ProductEntity entity = mapper.toEntity(dto);
        dto = mapper.toDto(service.create(entity));

        return ResponseEntity.of(Optional.of(dto));
    }
}
