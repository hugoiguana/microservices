package hugo.mota.microservices.mssales.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {

    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;

}
