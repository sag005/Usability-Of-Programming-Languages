package main.java;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class MenuItem implements Serializable, Cloneable {
    @JsonProperty("name")
    private String name;
    @JsonProperty("itemType")
    private ItemType itemType;

    @JsonProperty("menuType")
    private MenuType menuType;
    @JsonProperty("price")
    private Float price;
    @JsonProperty("isSpeciality")
    private Boolean isSpeciality;
    @JsonProperty("tableNumber")
    private int tableNumber;

    public MenuItem(String name, ItemType itemType, MenuType menuType, float price, Boolean isSpeciality, int tableNumber) {
        this.name = name;
        this.itemType = itemType;
        this.menuType = menuType;
        this.price = price;
        this.isSpeciality = isSpeciality;
        this.tableNumber = tableNumber;
    }

    public String getName() {
        return name;
    }

    public ItemType getDishType() {
        return itemType;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public Float getPrice() {
        return price;
    }

    public Boolean getSpeciality() {
        return isSpeciality;
    }


    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public MenuItem() {
    }
}
