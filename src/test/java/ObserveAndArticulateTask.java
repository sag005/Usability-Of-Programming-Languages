package test.java;

import main.java.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ObserveAndArticulateTask {

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

    public void observeAndArticulateTest() throws CloneNotSupportedException {

        Table availableTable = restaurant.getTable(3);
        Menu menu = restaurant.getMenu();

        /**
         * You have arrived at the restaurant during the brunch time.
         * we have placed order on your behalf. You have to decipher
         * what have we ordered for you based on the logic implemented below.
         *
         * Please think out loud when you decipher it!
         *
         * */
        availableTable.orderItem(
                Objects.requireNonNull(Objects.requireNonNull(menu)
                        .getDishes().stream()
                        .filter(i -> i.getDishType().equals(ItemType.NON_VEGETERIAN))
                        .filter(i -> i.getMenuType().equals(MenuType.LUNCH))
                        .findFirst()
                        .orElse(null)));

        availableTable.orderMultipleItems(
                Objects.requireNonNull(Objects.requireNonNull(menu)
                        .getDishes().stream()
                        .filter(i -> i.getDishType().equals(ItemType.NON_VEGETERIAN))
                        .filter(i -> i.getMenuType().equals(MenuType.BREAKFAST))
                        .limit(2L)).collect(Collectors.toList()));

        availableTable.orderItem(
                Objects.requireNonNull(Objects.requireNonNull(menu)
                        .getDishes().stream()
                        .filter(i -> i.getDishType().equals(ItemType.VEGETERIAN))
                        .filter(i -> i.getMenuType().equals(MenuType.BRUNCH))
                        .findFirst()
                        .orElse(null)));

        availableTable.orderItem(
                Objects.requireNonNull(Objects.requireNonNull(menu)
                        .getDishes().stream()
                        .filter(i -> i.getMenuType().equals(MenuType.DRINKS))
                        .filter(i -> i.getDishType().equals(ItemType.ALCOHOLIC))
                        .findFirst()
                        .orElse(null)));

        availableTable.orderItem(
                Objects.requireNonNull(Objects.requireNonNull(menu)
                        .getDishes().stream()
                        .filter(i -> i.getMenuType().equals(MenuType.DRINKS))
                        .filter(i -> i.getDishType().equals(ItemType.NON_ALCOHOLIC))
                        .findFirst()
                        .orElse(null)));
    }
}
