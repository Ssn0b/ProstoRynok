package app.snob.orderservice.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PayType {
    CREDIT_CARD("Credit Card"),
    PAYPAL("PayPal"),
    BANK_TRANSFER("Bank Transfer"),
    CASH_ON_DELIVERY("Cash on Delivery");
    private final String displayName;
    @Override
    public String toString() {
        return displayName;
    }
}
