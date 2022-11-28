package test.java;

import main.java.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TasksTest {

    @Test
    public void getOptimalTable() throws CloneNotSupportedException {
        Menu menu = DataStub.getMenu();
        List<Table> all_tables = DataStub.getTables();
        List<Server> all_servers = DataStub.getServers();

        Restaurant restaurant = new Restaurant(
                menu,
                all_servers,
                all_tables
        );

        Table availableTable = restaurant.getAvailableTableOptimally(4);
        assert availableTable.equals(all_tables.get(1));
    }

    @Test
    public void generateTableBill() throws CloneNotSupportedException {

        Menu menu = DataStub.getMenu();
        Table table = new Table(1, 3,
                0.0f, Collections.emptyList(),
                Collections.emptyList(), Boolean.TRUE, menu);

        table.orderItem(Objects.requireNonNull(menu).getDishes().get(0));
        table.orderItem(Objects.requireNonNull(menu).getDishes().get(1));
        table.orderItem(Objects.requireNonNull(menu).getDishes().get(2));
        table.orderItem(Objects.requireNonNull(menu).getDishes().get(3));
        table.orderItem(Objects.requireNonNull(menu).getDishes().get(4));
        table.orderItem(Objects.requireNonNull(menu).getDishes().get(6));

        table.addToAlreadyServedItems(Objects.requireNonNull(menu).getDishes().get(0));
        table.addToAlreadyServedItems(Objects.requireNonNull(menu).getDishes().get(1));
        table.addToAlreadyServedItems(Objects.requireNonNull(menu).getDishes().get(2));
        table.addToAlreadyServedItems(Objects.requireNonNull(menu).getDishes().get(3));
        table.addToAlreadyServedItems(Objects.requireNonNull(menu).getDishes().get(4));
        table.addToAlreadyServedItems(Objects.requireNonNull(menu).getDishes().get(6));


//        Boolean aBoolean = table.generateBill();
        Float billAmount = table.generateBill();

//        assert aBoolean.equals(Boolean.TRUE);
        assert billAmount.equals(107.33f);
    }

    @Test
    public void getRestaurantBill() throws CloneNotSupportedException {
        Menu menu = DataStub.getMenu();
        List<Table> all_tables = DataStub.getTables();
        List<Server> all_servers = DataStub.getServers();

        Restaurant restaurant = new Restaurant(
                menu,
                all_servers,
                all_tables
        );

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

        Float moneyMode = restaurant.getMoneyMade();
        assert moneyMode.equals(131.67f);
    }
}
