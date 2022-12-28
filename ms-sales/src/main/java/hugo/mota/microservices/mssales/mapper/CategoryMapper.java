package hugo.mota.microservices.mssales.mapper;

import hugo.mota.microservices.mssales.dto.CategoryDto;
import hugo.mota.microservices.mssales.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {

    CategoryEntity toEntity(CategoryDto dto);

    CategoryDto toDto(CategoryEntity entity);

}
