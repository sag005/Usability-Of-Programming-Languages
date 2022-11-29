package test.java;

import main.java.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CodeCompletionTask2 {

    private Restaurant restaurant;

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
     * Alright so you have successfully placed order with us, we hope you enjoyed the meal!
     * <p>
     * Now is the time to ask for your bill. But we are very sorry our logic for bill generation is missing.
     * Please help us write the logic for the same.
     * <p>
     * You have been provided a method {@link Table#generateBill()} with some starter code. You need to
     * complete the rest of the logic.
     * <p>
     * In a nutshell, we want to
     * 1. Check if all items ordered are served to table and nothing is pending in kitchen.
     * 2. Iterate over all items ordered and total the amount based on individual {@link MenuItem} price
     */

    @Test
    public void testGenerateBill() throws CloneNotSupportedException {
        Table table = DataStub.getTableStub(restaurant, 5);
        Float billGenerated = table.generateBill();
        assert billGenerated.equals(129.44f);
    }
}
