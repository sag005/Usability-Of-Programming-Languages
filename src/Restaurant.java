import java.util.ArrayList;
import java.util.Optional;

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

    private Table getTable(int guestCount) {
        Table table = getAvailableTable(guestCount);
        Server server = getAvailableServer();
        if (table == null || server == null) {
            return null;
        } else {
            table.setServer(server);
        }
        return table;
    }

    private Server getAvailableServer() {
        for(Server server: this.servers){
            if(server.getServingCapacity() > server.getTableServing().size()){
                return server;
            }
        }
        return null;
    }

    private Table getAvailableTable(int guestCount) {
        for(Table table: this.tables){
            if(table.getAccessible() && guestCount<=table.getCapacity()) return table;
        }
        return null;
    }

    private Table getAvailableTableOptimal(int guestCount) {
        int answer = Integer.MAX_VALUE;
        Table optimalTable = null;

        for(Table table: this.tables){
            if(table.getAccessible() && guestCount<=table.getCapacity()){
                if(table.getCapacity()<answer){
                    answer = table.getCapacity();
                    optimalTable = table;
                }
            }
        }
        return optimalTable;
    }

    private Boolean collectTableBills() {
        // Update this.moneyMade 
        return true;
    }





}
