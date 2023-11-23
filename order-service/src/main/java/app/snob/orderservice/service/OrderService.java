package app.snob.orderservice.service;

import app.snob.orderservice.dto.OrderRequest;
import app.snob.orderservice.dto.OrderResponse;
import app.snob.orderservice.event.OrderPlacedEvent;
import app.snob.orderservice.model.Order;
import app.snob.orderservice.model.OrderLineItems;
import app.snob.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void createOrder(OrderRequest orderRequest) {
        Order order = Order.builder()
                .userId(orderRequest.getUserId())
                .orderDate(orderRequest.getOrderDate())
                .orderStatus(orderRequest.getOrderStatus())
                .payType(orderRequest.getPayType())
                .deliverType(orderRequest.getDeliverType())
                .orderLineItemsList(orderRequest.getOrderLineItemsList())
                .price(orderRequest.getPrice())
                .build();
        orderRepository.save(order);
        kafkaTemplate.send("notificationTopic",
                new OrderPlacedEvent(order.getOrderLineItemsList()
                        .stream().collect(Collectors.toMap(
                        OrderLineItems::getSkuCode,
                        OrderLineItems::getQuantity
                ))));
        log.info("Order {} is saved", order.getId());
    }

    public List<OrderResponse> getAllOrders(){
        return orderRepository.findAll()
                .stream()
                .map(this::mapToProductResponse)
                .collect(Collectors.toList());
    }

    private OrderResponse mapToProductResponse(Order order){
        return OrderResponse.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .orderDate(order.getOrderDate())
                .orderStatus(order.getOrderStatus())
                .payType(order.getPayType())
                .deliverType(order.getDeliverType())
                .orderLineItemsList(order.getOrderLineItemsList())
                .price(order.getPrice())
                .build();
    }
}
