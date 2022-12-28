package hugo.mota.microservices.mssales.controller;

import hugo.mota.microservices.mssales.dto.CategoryDto;
import hugo.mota.microservices.mssales.entity.CategoryEntity;
import hugo.mota.microservices.mssales.mapper.CategoryMapper;
import hugo.mota.microservices.mssales.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @Autowired
    private CategoryMapper mapper;


    @GetMapping("")
    public ResponseEntity<List<CategoryDto>> getAll() {

        List<CategoryDto> products = service.findAll().stream().map(p -> mapper.toDto(p)).collect(Collectors.toList());

        return ResponseEntity.of(Optional.of(products));
    }

    @PostMapping
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto dto) {

        CategoryEntity entity = mapper.toEntity(dto);
        dto = mapper.toDto(service.create(entity));

        return ResponseEntity.of(Optional.of(dto));
    }
}
