package main.java;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class DataStub {

    public static Menu getMenu() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<MenuItem> menuItems = mapper.readValue(Paths.get("src/main/java/MenuItems.json").toFile(), new TypeReference<List<MenuItem>>() {
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

    public static void populateTableWithRandomFood(Table table) {
        List<MenuItem> dishes = table.getMenu().getDishes();

        IntStream ints = new Random().ints(5, 0, 11);
        ints.asLongStream().forEach(i -> table.addToPendingItemsToBeServed(dishes.get((int) i)));

        ints = new Random().ints(5, 0, 11);
        ints.asLongStream().forEach(i -> table.addToAlreadyServedItems(dishes.get((int) i)));
    }

    public static Table getFriendTableStub(Restaurant restaurant, Integer guestCount) {
        Table friendTable = restaurant.getAvailableTableOptimally(guestCount);
        friendTable.addToAlreadyServedItems(restaurant.getMenu().getDishes().get(0));
        friendTable.addToAlreadyServedItems(restaurant.getMenu().getDishes().get(1));
        friendTable.addToAlreadyServedItems(restaurant.getMenu().getDishes().get(2));

        friendTable.addToPendingItemsToBeServed(restaurant.getMenu().getDishes().get(3));
        friendTable.addToPendingItemsToBeServed(restaurant.getMenu().getDishes().get(4));
        friendTable.addToPendingItemsToBeServed(restaurant.getMenu().getDishes().get(5));
        friendTable.addToPendingItemsToBeServed(restaurant.getMenu().getDishes().get(6));

        return friendTable;

    }
}
