package app.snob.orderservice.dto;

import app.snob.orderservice.model.DeliverType;
import app.snob.orderservice.model.OrderLineItems;
import app.snob.orderservice.model.OrderStatus;
import app.snob.orderservice.model.PayType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private UUID id;
    private UUID userId;
    private Date orderDate;
    private OrderStatus orderStatus;
    private PayType payType;
    private DeliverType deliverType;
    private List<OrderLineItems> orderLineItemsList;
    private BigDecimal price;

}
