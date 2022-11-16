import java.util.ArrayList;

public class Table {
    private Server server;
    private final int tableNumber;
    private final int capacity;
    private float billAmount;
    private ArrayList<MenuItem> pendingItemsToBeServed;
    private ArrayList<MenuItem> alreadyServedItems;

    private Boolean isAccessible;


    public Table(Server server, int tableNumber, int capacity, float billAmount, ArrayList<MenuItem> pendingItemsToBeServed, ArrayList<MenuItem> alreadyServedItems, Boolean isAccessible) {
        this.server = server;
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.billAmount = billAmount;
        this.pendingItemsToBeServed = pendingItemsToBeServed;
        this.alreadyServedItems = alreadyServedItems;
        this.isAccessible = isAccessible;
    }
}
