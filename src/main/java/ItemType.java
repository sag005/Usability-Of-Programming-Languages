package main.java;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ItemType {
    VEGETERIAN("veg"),
    VEGAN("vegan"),
    NON_VEGETERIAN("non-veg"),
    ALCOHOLIC("alcoholic"),
    NON_ALCOHOLIC("non-alcoholic"),
    DESSERT("dessert");

    private final String itemTypeString;

    ItemType(String itemTypeString) {
        this.itemTypeString = itemTypeString;
    }

    @JsonValue
    public String getFoodTypeString() {
        return itemTypeString;
    }
}
