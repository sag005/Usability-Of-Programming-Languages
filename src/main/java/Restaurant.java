package main.java;

import java.util.List;
import java.util.Map;
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

    public Table getOptimalAvailableTable(int guestCount) {
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
        for(Table table: this.tables){
            if(!table.getAccessible()){
                this.moneyMade += table.generateBill();
            }
        }
        return true;
    }

    public Double getEstimatedTipForServer(Server server) {
        //
        Map<Integer, Tip> tableServing = server.getTableServing();

        Map<MenuItem, Float> allPendingItemsAcrossTables = tableServing.keySet().parallelStream()
                .map(i -> this.tables.get(i))
                .flatMap(t -> t.getPendingItemsToBeServed().stream())
                .collect(Collectors.toMap(item -> item, MenuItem::getPrice, (p1, p2) -> p1));

        Map<MenuItem, Float> allServedItemsAcrossTables = tableServing.keySet().parallelStream()
                .map(i -> this.tables.get(i))
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
