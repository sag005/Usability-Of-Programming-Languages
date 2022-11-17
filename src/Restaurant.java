import java.util.ArrayList;

public class Restaurant {
    private final ArrayList<Chef> chefs;
    private final ArrayList<Menu> menus;
    private final ArrayList<Server> servers;

    private ArrayList<Table> tables;
    private float moneyMade = 0;

    public Restaurant(ArrayList<Chef> chefs, ArrayList<Menu> menus, ArrayList<Server> servers, ArrayList<Table> tables) {
        this.chefs = chefs;
        this.menus = menus;
        this.servers = servers;
        this.tables = tables;
    }

    private Boolean getTable(int guestCount){
        return true;
    }

    private Boolean collectTableBills(){
        // Update this.moneyMade 
        return true;
    }



}
