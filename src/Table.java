import java.util.ArrayList;

public class Table {
    private Server server;
    private final int tableNumber;
    private final int capacity;
    private float billAmount;
    private ArrayList<MenuItem> pendingItemsToBeServed;
    private ArrayList<MenuItem> alreadyServedItems;
    private Menu menu;

    private Boolean isAccessible;


    public Table(int tableNumber, int capacity, float billAmount, ArrayList<MenuItem> pendingItemsToBeServed, ArrayList<MenuItem> alreadyServedItems, Boolean isAccessible, Menu menu) {
        // this.server = server;
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        // this.billAmount = billAmount;
        // this.pendingItemsToBeServed = pendingItemsToBeServed;
        // this.alreadyServedItems = alreadyServedItems;
        this.isAccessible = isAccessible;
        this.menu = menu;
    }

    public void setServer(Server server){
        this.server = server;
    }
    public Menu getMenu(){
        return this.menu;
    }
    public Boolean orderItems(ArrayList<MenuItem> items){
        return true;
    }
    public Boolean generateBill(){
        return true;
    }
    public Boolean serveItems(){
        return true;
    }
}
