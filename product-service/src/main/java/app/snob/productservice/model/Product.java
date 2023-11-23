package app.snob.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    @Id
    private String id;
    private String name;
    private String skuCode;
    private UUID producerId;
    private List<ProductCategory> categoryList;
    private String description;
    private int expirationDate; // термін зберігання в днях
    private List<String> photoUrl; // @TODO implement s3
    private Map<String, Object> additionalFields;
    private Integer quantity;
    private BigDecimal priceByOne;
}
