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
        Table table = getAvailableTable();
        Server server = getAvailableServer();
        if (table == null || server == null) {
            return null;
        } else {
            table.setServer(server);
        }
        return table;
    }

    private Server getAvailableServer() {
        Optional<Server> availableServerOption = this.servers.stream()
                .filter(s -> s.getServingCapacity() > s.getTableServing().size())
                .findFirst();
        return availableServerOption.orElse(null);
    }

    private Table getAvailableTable() {
        Optional<Table> availableTableOption = this.tables.stream()
                .filter(Table::getAccessible)
                .findFirst();
        return availableTableOption.orElse(null);
    }

    private Boolean collectTableBills() {
        // Update this.moneyMade 
        return true;
    }





}
