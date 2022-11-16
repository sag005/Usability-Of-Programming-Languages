public enum ItemType {
    VEGETERIAN("veg"),
    VEGAN("vegan"),
    NON_VEGETERIAN("non-veg"),
    WINE("wine"),
    DESSERT("dessert");

    private final String itemTypeString;

    ItemType(String itemTypeString) {
        this.itemTypeString = itemTypeString;
    }

    public String getFoodTypeString() {
        return itemTypeString;
    }
}
