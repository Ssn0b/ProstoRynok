package app.snob.productservice.service;

import app.snob.productservice.dto.ProductRequest;
import app.snob.productservice.model.Product;
import app.snob.productservice.model.coffee.Coffee;
import app.snob.productservice.repository.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CoffeeService {
    private final CoffeeRepository coffeeRepository;

    public void createCoffee(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .categoryList(productRequest.getCategoryList())
                .expirationDate(productRequest.getExpirationDate())
                .photoUrl(productRequest.getPhotoUrl())
                .additionalFields(productRequest.getAdditionalFields())
                .build();

        Coffee coffee = (Coffee) product;

        coffee = Coffee.builder()
                .coffeeType(coffeeRequest.getCoffeeType())
                .grainOrigin(coffeeRequest.getGrainOrigin())
                .build();

        coffeeRepository.save(coffee);
        log.info("Product {} is saved", coffee.getId());
    }
    public List<CoffeeResponse> getAllCoffees(){
        return coffeeRepository.findAll()
                .stream()
                .map(this::mapToProductResponse)
                .collect(Collectors.toList());
    }

    private CoffeeResponse mapToProductResponse(Coffee coffee){
        return CoffeeResponse.builder()
                .id(coffee.getId())
                .name(coffee.getName())
                .categoryList(coffee.getCategoryList())
                .description(coffee.getDescription())
                .expirationDate(coffee.getExpirationDate())
                .photoUrl(coffee.getPhotoUrl())
                .coffeeType(coffee.getCoffeeType())
                .grainOrigin(coffee.getGrainOrigin())
                .build();
    }
}
