package main.java;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private Server server;
    private final int tableNumber;
    private final Integer capacity;
    private Float billAmount = 0.0f;
    private List<MenuItem> pendingItemsToBeServed = new ArrayList<>();
    private List<MenuItem> alreadyServedItems = new ArrayList<>();
    private Menu menu;
    private Boolean isAccessible;


    public Table(int tableNumber, Integer capacity, float billAmount, List<MenuItem> pendingItemsToBeServed, List<MenuItem> alreadyServedItems, Boolean isAccessible, Menu menu) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.isAccessible = isAccessible;
        this.menu = menu;
    }

    public void orderItem(MenuItem menuItem) throws CloneNotSupportedException {
        MenuItem itemOrdered = (MenuItem) menuItem.clone();
        itemOrdered.setTableNumber(this.getTableNumber());
        this.getPendingItemsToBeServed().add(itemOrdered);
    }

    public void orderMultipleItems(List<MenuItem> menuItems) throws CloneNotSupportedException {
        menuItems.forEach(item -> {
            MenuItem itemOrdered = null;
            try {
                itemOrdered = (MenuItem) item.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
            itemOrdered.setTableNumber(this.getTableNumber());
            this.getPendingItemsToBeServed().add(itemOrdered);
        });

    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Float getBillAmount() {
        return billAmount;
    }

    public Float generateBill() {
        if (alreadyServedItems.size() > 0) {
            //Update this.billAmount
            Float sum = 0.0f;
            for(MenuItem item: alreadyServedItems){
                sum += item.getPrice();
            }
            this.billAmount = sum;
            this.isAccessible = true;
            this.alreadyServedItems = new ArrayList<>();
            this.server = null;
            return this.billAmount;
        }
        throw new RuntimeException(
                "Cannot generate bill as the pending items are still not served or you have not ordered anything!");
    }

    public List<MenuItem> getPendingItemsToBeServed() {
        return pendingItemsToBeServed;
    }

    public void addToPendingItemsToBeServed(MenuItem pendingItemToBeServed) {
        this.pendingItemsToBeServed.add(pendingItemToBeServed);
    }

    public List<MenuItem> getAlreadyServedItems() {
        return alreadyServedItems;
    }

    public void addToAlreadyServedItems(MenuItem alreadyServedItem) {
        this.alreadyServedItems.add(alreadyServedItem);
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Boolean getAccessible() {
        return isAccessible;
    }

    public void setAccessible(Boolean accessible) {
        isAccessible = accessible;
    }
}
