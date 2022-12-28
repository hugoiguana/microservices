package hugo.mota.microservices.mssales.service;

import hugo.mota.microservices.mssales.entity.CategoryEntity;
import hugo.mota.microservices.mssales.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CategoryService {

    CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public CategoryEntity create(CategoryEntity entity) {
        return repository.save(entity);
    }

    public List<CategoryEntity> findAll() {
        return repository.findAll();
    }
}
