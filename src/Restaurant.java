import java.util.ArrayList;

public class Restaurant {
    private final ArrayList<Chef> chefs;
    private final ArrayList<Menu> menus;
    private final ArrayList<Server> servers;

    private ArrayList<Table> tables;

    public Restaurant(ArrayList<Chef> chefs, ArrayList<Menu> menus, ArrayList<Server> servers, ArrayList<Table> tables) {
        this.chefs = chefs;
        this.menus = menus;
        this.servers = servers;
        this.tables = tables;
    }


}
