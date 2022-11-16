public class MenuItem {
    private final String name;
    private final ItemType itemType;
    private final float price;
    private final Boolean isSpeciality;

    private int tableNumber;

    public MenuItem(String name, ItemType itemType, float price, Boolean isSpeciality, int tableNumber) {
        this.name = name;
        this.itemType = itemType;
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

    public float getPrice() {
        return price;
    }

    public Boolean getSpeciality() {
        return isSpeciality;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}
