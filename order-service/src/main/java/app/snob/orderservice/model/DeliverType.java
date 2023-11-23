package app.snob.orderservice.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum DeliverType {
    SELF_PICKUP("Self pickup"),
    NOVA_POSHTA("Nova Poshta"),
    UKR_POSHTA("UkrPoshta"),
    SELLER("Seller");
    private final String displayName;
    @Override
    public String toString() {
        return displayName;
    }
}
