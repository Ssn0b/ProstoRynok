package app.snob.productservice.service;

import app.snob.productservice.dto.ProductRequest;
import app.snob.productservice.dto.ProductResponse;
import app.snob.productservice.event.OrderPlacedEvent;
import app.snob.productservice.model.Product;
import app.snob.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .producerId(productRequest.getProducerId())
                .skuCode(productRequest.getSkuCode())
                .description(productRequest.getDescription())
                .categoryList(productRequest.getCategoryList())
                .expirationDate(productRequest.getExpirationDate())
                .photoUrl(productRequest.getPhotoUrl())
                .additionalFields(productRequest.getAdditionalFields())
                .quantity(productRequest.getQuantity())
                .priceByOne(productRequest.getPriceByOne())
                .build();
        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(this::mapToProductResponse)
                .collect(Collectors.toList());
    }

    @KafkaListener(topics = "notificationTopic")
    public void handleNotification(OrderPlacedEvent orderPlacedEvent) {
        Map<String, Integer> productsSkusAndQuantity = orderPlacedEvent.getProductsSkusAndQuantity();
        Set<String> skus = productsSkusAndQuantity.keySet();
        for (String sku : skus) {
            log.info("Product with sku code quantity {} is updated", sku);
            Integer quantity = productsSkusAndQuantity.get(sku);
            Product product = productRepository.findBySkuCode(sku);
            product.setQuantity(product.getQuantity()-quantity);
            productRepository.save(product);
        }
    }

    private ProductResponse mapToProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .producerId(product.getProducerId())
                .skuCode(product.getSkuCode())
                .categoryList(product.getCategoryList())
                .description(product.getDescription())
                .expirationDate(product.getExpirationDate())
                .photoUrl(product.getPhotoUrl())
                .additionalFields(product.getAdditionalFields())
                .priceByOne(product.getPriceByOne())
                .quantity(product.getQuantity())
                .build();
    }
}
