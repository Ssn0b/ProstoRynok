package app.snob.orderservice.event;

import lombok.*;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPlacedEvent {
    private Map<String, Integer> productsSkusAndQuantity;
}
