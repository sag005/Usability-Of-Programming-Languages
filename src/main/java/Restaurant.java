package main.java;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Restaurant {
    private final Menu menu;
    private final List<Server> servers;
    private List<Table> tables;
    private float moneyMade = 0;

    public Restaurant(Menu menu, List<Server> servers, List<Table> tables) {
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

    public Table getOptimalAvailableTable(int guestCount) {
        Table optimalTable = this.tables.stream()
                .filter(Table::getAccessible)
                .filter(t -> guestCount <= t.getCapacity())
                .min(Comparator.comparingInt(Table::getCapacity))
                .orElse(null);

        return optimalTable;
    }

    private Boolean collectTableBills() {
        // Update this.moneyMade
        this.moneyMade = this.tables.stream()
                .filter(t -> !t.getAccessible())
                .map(Table::generateBill)
                .reduce((float) 0, Float::sum);
        return true;
    }

    public Double getEstimatedTipForServer(Server server) {
        //
        Map<Integer, Tip> tableServing = server.getTableServing();

        Map<MenuItem, Float> allPendingItemsAcrossTables =
                tableServing.keySet().parallelStream()
                        .map(i -> this.tables.get(i - 1))
                        .flatMap(t -> t.getPendingItemsToBeServed().stream())
                        .collect(Collectors.toMap(item -> item, MenuItem::getPrice, (p1, p2) -> p1));

        Map<MenuItem, Float> allServedItemsAcrossTables = tableServing.keySet().parallelStream()
                .map(i -> this.tables.get(i - 1))
                .flatMap(t -> t.getAlreadyServedItems().stream())
                .collect(Collectors.toMap(item -> item, MenuItem::getPrice, (p1, p2) -> p1));

        Double tipFromPendingItems = allPendingItemsAcrossTables.values().stream()
                .map(p -> p * .1)
                .reduce(0.0, Double::sum);
        Double tipFromServedItems = allServedItemsAcrossTables.values().stream()
                .map(p -> p * .1)
                .reduce(0.0, Double::sum);

        return tipFromServedItems + tipFromPendingItems;
    }

    public Menu getMenu() {
        return menu;
    }

    public List<Server> getServers() {
        return servers;
    }

    public List<Table> getTables() {
        return tables;
    }

    public float getMoneyMade() {
        this.collectTableBills();
        return moneyMade;
    }
}
