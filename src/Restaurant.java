import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Restaurant {
    private final Chef chef;
    private final Menu menu;
    private final List<Server> servers;
    private List<Table> tables;
    private float moneyMade = 0;

    public Restaurant(Chef chef, Menu menu, List<Server> servers, List<Table> tables) {
        this.chef = chef;
        this.menu = menu;
        this.servers = servers;
        this.tables = tables;
    }

    public Table getTable(int guestCount) {
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
        Optional<Server> availableServerOption = this.servers.stream()
                .filter(s -> s.getServingCapacity() > s.getTableServing().size())
                .findFirst();
        return availableServerOption.orElse(null);
    }

    private Table getAvailableTable(int guestCount) {
        Optional<Table> availableTableOption = this.tables.stream()
                .filter(Table::getAccessible)
                .filter(t -> t.getCapacity() >= guestCount)
                .findFirst();
        return availableTableOption.orElse(null);
    }

    private Table getAvailableTableOptimally(int guestCount) {
        Optional<Table> availableTableOption = this.tables.stream()
                .filter(Table::getAccessible)
                .filter(t -> t.getCapacity() >= guestCount)
                .min(Comparator.comparingInt(Table::getCapacity));
        return availableTableOption.orElse(null);
    }

    private Boolean collectTableBills() {
        // Update this.moneyMade 
        return true;
    }





}
