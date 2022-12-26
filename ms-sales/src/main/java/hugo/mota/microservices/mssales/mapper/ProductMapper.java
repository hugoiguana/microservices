package hugo.mota.microservices.mssales.mapper;

import hugo.mota.microservices.mssales.dto.ProductDto;
import hugo.mota.microservices.mssales.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    ProductEntity toEntity(ProductDto dto);

    ProductDto toDto(ProductEntity entity);

}
