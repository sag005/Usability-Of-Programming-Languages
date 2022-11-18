import java.util.ArrayList;
import java.util.List;

public class Table {
    private Server server;
    private final int tableNumber;
    private final int capacity;
    private Float billAmount;
    private List<MenuItem> pendingItemsToBeServed = new ArrayList<>();
    private List<MenuItem> alreadyServedItems = new ArrayList<>();
    private Menu menu;
    private Boolean isAccessible;


    public Table(int tableNumber, int capacity, float billAmount, ArrayList<MenuItem> pendingItemsToBeServed, ArrayList<MenuItem> alreadyServedItems, Boolean isAccessible, Menu menu) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.isAccessible = isAccessible;
        this.menu = menu;
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

    public int getCapacity() {
        return capacity;
    }

    public Float getBillAmount() {
        return billAmount;
    }

    // Implement the below function to generate bill for already served items.
    public Boolean generateBill() {
        return true;
    }

    public List<MenuItem> getPendingItemsToBeServed() {
        return pendingItemsToBeServed;
    }

    public void setPendingItemsToBeServed(List<MenuItem> pendingItemsToBeServed) {
        this.pendingItemsToBeServed = pendingItemsToBeServed;
    }

    public List<MenuItem> getAlreadyServedItems() {
        return alreadyServedItems;
    }

    public void setAlreadyServedItems(List<MenuItem> alreadyServedItems) {
        this.alreadyServedItems = alreadyServedItems;
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
