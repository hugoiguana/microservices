package hugo.mota.microservices.mssales.controller;

import hugo.mota.microservices.mssales.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("products")
public class ProductController {


    @GetMapping("")
    public ResponseEntity<List<ProductDto>> getAll() {

        return ResponseEntity.of(Optional.of(asList(ProductDto.builder().name("Prod1").price(BigDecimal.TEN).build())));
    }

}
