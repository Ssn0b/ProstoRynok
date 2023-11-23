package app.snob.orderservice.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum OrderStatus {
    PROCESSING ("Processing"),
    SHIPPED("Shipped"),
    DELIVERED ("Delivered"),
    CANCELLED ("Cancelled");
    private final String displayName;
    @Override
    public String toString() {
        return displayName;
    }
}
