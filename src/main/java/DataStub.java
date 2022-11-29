package main.java;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DataStub {

    public static Menu getMenu() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<MenuItem> menuItems = mapper.readValue(Paths.get("/Users/abhilash/courses_ucsd/usability of pl/proj/Usability-Of-Programming-Languages/src/main/java/MenuItems.json").toFile(), new TypeReference<List<MenuItem>>() {
            });
            return new Menu(menuItems);
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }


    public static List<Table> getTables() {
        List<Table> all_tables = new ArrayList<>();
        all_tables.add(new Table(1, 3, 0.0f, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Boolean.TRUE, getMenu()));
        all_tables.add(new Table(2, 4, 0.0f, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Boolean.TRUE, getMenu()));
        all_tables.add(new Table(3, 2, 0.0f, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Boolean.TRUE, getMenu()));
        all_tables.add(new Table(4, 8, 0.0f, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Boolean.TRUE, getMenu()));
        all_tables.add(new Table(5, 2, 0.0f, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Boolean.TRUE, getMenu()));
        all_tables.add(new Table(6, 5, 0.0f, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Boolean.TRUE, getMenu()));
        all_tables.add(new Table(7, 3, 0.0f, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Boolean.TRUE, getMenu()));
        all_tables.add(new Table(8, 4, 0.0f, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Boolean.TRUE, getMenu()));
        all_tables.add(new Table(9, 9, 0.0f, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Boolean.TRUE, getMenu()));
        all_tables.add(new Table(10, 6, 0.0f, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Boolean.TRUE, getMenu()));
        return all_tables;
    }

    public static List<Server> getServers() {
        List<Server> all_servers = new ArrayList<>();
        all_servers.add(new Server(2));
        all_servers.add(new Server(1));
        all_servers.add(new Server(3));
        all_servers.add(new Server(3));
        all_servers.add(new Server(1));
        return all_servers;
    }

    public static Table getTableStub(Restaurant restaurant, Integer guestCount) {
        Table friendTable = restaurant.getOptimalAvailableTable(guestCount);
        friendTable.addToAlreadyServedItems(restaurant.getMenu().getDishes().get(0));
        friendTable.addToAlreadyServedItems(restaurant.getMenu().getDishes().get(1));
        friendTable.addToAlreadyServedItems(restaurant.getMenu().getDishes().get(2));

        friendTable.addToAlreadyServedItems(restaurant.getMenu().getDishes().get(3));
        friendTable.addToAlreadyServedItems(restaurant.getMenu().getDishes().get(4));
        friendTable.addToAlreadyServedItems(restaurant.getMenu().getDishes().get(5));
        friendTable.addToAlreadyServedItems(restaurant.getMenu().getDishes().get(6));

        return friendTable;

    }

    public static Server getServerForTipEstimation(Restaurant restaurant) {
        Server server = restaurant.getServers().get(2);
        server.getTableServing().put(1, new Tip(0.0));
        server.getTableServing().put(2, new Tip(0.0));
        server.getTableServing().put(3, new Tip(0.0));

        List<Table> all_tables = restaurant.getTables();
        all_tables.get(0).addToPendingItemsToBeServed(restaurant.getMenu().getDishes().get(0));
        all_tables.get(0).addToAlreadyServedItems(restaurant.getMenu().getDishes().get(4));
        all_tables.get(0).addToAlreadyServedItems(restaurant.getMenu().getDishes().get(2));

        all_tables.get(1).addToPendingItemsToBeServed(restaurant.getMenu().getDishes().get(1));
        all_tables.get(1).addToAlreadyServedItems(restaurant.getMenu().getDishes().get(2));

        all_tables.get(2).addToPendingItemsToBeServed(restaurant.getMenu().getDishes().get(3));
        all_tables.get(2).addToPendingItemsToBeServed(restaurant.getMenu().getDishes().get(1));
        all_tables.get(2).addToAlreadyServedItems(restaurant.getMenu().getDishes().get(0));

        return server;
    }

    public static void setupTablesForRevenueGeneration(Restaurant restaurant) throws CloneNotSupportedException {
        List<Table> all_tables = restaurant.getTables();
        Menu menu = restaurant.getMenu();
        Table table1 = all_tables.get(0);
        table1.orderItem(Objects.requireNonNull(menu).getDishes().get(0));
        table1.orderItem(Objects.requireNonNull(menu).getDishes().get(1));
        table1.orderItem(Objects.requireNonNull(menu).getDishes().get(2));
        table1.orderItem(Objects.requireNonNull(menu).getDishes().get(3));
        table1.orderItem(Objects.requireNonNull(menu).getDishes().get(4));
        table1.orderItem(Objects.requireNonNull(menu).getDishes().get(6));

        table1.addToAlreadyServedItems(Objects.requireNonNull(menu).getDishes().get(0));
        table1.addToAlreadyServedItems(Objects.requireNonNull(menu).getDishes().get(1));
        table1.addToAlreadyServedItems(Objects.requireNonNull(menu).getDishes().get(2));
        table1.addToAlreadyServedItems(Objects.requireNonNull(menu).getDishes().get(3));
        table1.addToAlreadyServedItems(Objects.requireNonNull(menu).getDishes().get(4));
        table1.addToAlreadyServedItems(Objects.requireNonNull(menu).getDishes().get(6));
        table1.setAccessible(Boolean.FALSE);

        Table table2 = all_tables.get(1);
        table2.orderItem(Objects.requireNonNull(menu).getDishes().get(0));
        table2.addToAlreadyServedItems(Objects.requireNonNull(menu).getDishes().get(0));
        table2.setAccessible(Boolean.FALSE);

    }
}
