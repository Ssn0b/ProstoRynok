package app.snob.productservice.model;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public enum ProductCategory {
    VEGETABLES("Vegetables"),
    FRUITS("Fruits"),
    TEA("Tea"),
    Dairy("Dairy"),
    MEAT("Meat"),
    GROCERY("Grocery"),
    BAKERY("Bakery"),
    BEVERAGES("Beverages"),
    DESSERTS("Desserts"),
    SEAFOOD("Seafood"),
    GRAINS("Grains"),
    CANNED_GOODS("Canned goods"),
    HERBS("Herbs"),
    COFFEE("Coffee"),
    FROZEN_FOODS("Frozen foods"),
    SAUCES("Sauces"),
    SPICES("Spices"),
    ORGANIC("Organic"),
    HAY("Hay");
    private final String displayName;
    @Override
    public String toString() {
        return displayName;
    }
}
