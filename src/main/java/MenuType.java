package main.java;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MenuType {
    BREAKFAST("breakfast"),
    LUNCH("lunch"),
    BRUNCH("brunch"),
    DRINKS("drinks ");

    private final String menuType;

    MenuType(String menuType) {

        this.menuType = menuType;
    }

    @JsonValue
    public String getMenuType() {
        return menuType;
    }
}
