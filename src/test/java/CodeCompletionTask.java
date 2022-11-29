package test.java;

import main.java.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CodeCompletionTask {

    private Restaurant restaurant;
    private Table availableTable;

    @BeforeEach
    public void setUp() {
        Menu menu = DataStub.getMenu();
        List<Table> all_tables = DataStub.getTables();
        List<Server> all_servers = DataStub.getServers();

        restaurant = new Restaurant(
                menu,
                all_servers,
                all_tables
        );
    }


    /**
     * Welcome to Restaurant 291.
     * We have a variety of food items, some are our speciality. You can access the list via {@link Menu} option.
     * We provide support different operations such as - orderFood, generateBill, mergeTables.
     * Enjoy your meal!!
     * */

    /**
     * To get started you need to ask for a {@link Table}.
     * If the {@link Table} is available we would provide you with one {@link Server} and one {@link Menu}
     * But we cannot provide you table just like that, we have to optimize our seating arrangement.
     * Therefore, we need your help to enhance our functionality to assign table to customers
     * based on customer count.
     * <p>
     * Assign a table with the smallest capacity, greater than or equals to number of guest.
     * <p>
     * You need to complete the function {@link Restaurant#getOptimalAvailableTable(int)}
     */

    @Test
    public void getTableOptimally() throws CloneNotSupportedException {
        List<Table> all_tables = restaurant.getTables();
        availableTable = restaurant.getOptimalAvailableTable(4);
        assert availableTable.equals(all_tables.get(1));

    }
}
