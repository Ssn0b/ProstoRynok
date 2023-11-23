package app.snob.productservice.dto;

import app.snob.productservice.model.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String name;
    private String skuCode;
    private UUID producerId;
    private List<ProductCategory> categoryList;
    private String description;
    private int expirationDate; // термін зберігання в днях
    private List<String> photoUrl;
    private Map<String, Object> additionalFields;
    private Integer quantity;
    private BigDecimal priceByOne;
}
