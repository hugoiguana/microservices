package hugo.mota.microservices.mssales.service;

import hugo.mota.microservices.mssales.entity.ProductEntity;
import hugo.mota.microservices.mssales.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProductService {

    ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ProductEntity create(ProductEntity entity) {
        return repository.save(entity);
    }

    public List<ProductEntity> findAll() {
        return repository.findAll();
    }
}
