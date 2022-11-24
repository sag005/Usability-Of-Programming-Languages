package main.java;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        /**
         * Welcome to Restaurant 291.
         * To get started you need to ask for a {@link Table}.
         * If the {@link Table} is available we would provide you with one {@link Server} and one {@link Menu}
         * We have a variety of food items, some are our speciality. You can access the list via {@link Menu} option.
         * We provide support different operations such as - orderFood, generateBill, mergeTables.
         * Enjoy your meal!!
         * */

        List<Table> all_tables = DataStub.getTables();
        List<Server> all_servers = DataStub.getServers();
        Menu menu = DataStub.getMenu();

        Restaurant restaurant = new Restaurant(
                menu,
                all_servers,
                all_tables
        );

        Table table = restaurant.getTable(5);

        /**
         * Our proud servers are being tipped 10% of the table bill.
         *
         * You are provided with the logical implementation of how a server can check their
         * estimated tip based on the tables they are serving and the food already served or
         * is about to be served. The tip returned is cumulative tip expected from all tables.
         *
         * {@link Restaurant#getEstimatedTipForServer(Server) code}
         *
         * You are provided with one of the servers from our restaurant.
         * The server is not happy with the return estimate of the tip and ask us to revisit the logic.
         * We need you help to find the bug in the logic and fix it.
         *
         * For this task you need to make sure the test runs in the test file.
         * */


        /**
         * You have arrived at the restaurant during the brunch time.
         * Your task is to order items of your choice with below variety.
         *  a. Order one NON_VEG, LUNCH item
         *  b. Order two NON_VEG BREAKFAST item.
         *  c. Order one VEG BRUNCH items.
         *  d. Order one NON_ALCOHOLIC items.
         *  e. Order one ALCOHOLIC items.
         * */
        table.orderItem(
                Objects.requireNonNull(Objects.requireNonNull(menu)
                        .getDishes().stream()
                        .filter(i -> i.getDishType().equals(ItemType.NON_VEGETERIAN))
                        .filter(i -> i.getMenuType().equals(MenuType.LUNCH))
                        .findFirst()
                        .orElse(null)));

        table.orderMultipleItems(
                Objects.requireNonNull(Objects.requireNonNull(menu)
                        .getDishes().stream()
                        .filter(i -> i.getDishType().equals(ItemType.NON_VEGETERIAN))
                        .filter(i -> i.getMenuType().equals(MenuType.BREAKFAST))
                        .limit(2L)).collect(Collectors.toList()));

        table.orderItem(
                Objects.requireNonNull(Objects.requireNonNull(menu)
                        .getDishes().stream()
                        .filter(i -> i.getDishType().equals(ItemType.VEGETERIAN))
                        .filter(i -> i.getMenuType().equals(MenuType.BRUNCH))
                        .findFirst()
                        .orElse(null)));

        table.orderItem(
                Objects.requireNonNull(Objects.requireNonNull(menu)
                        .getDishes().stream()
                        .filter(i -> i.getMenuType().equals(MenuType.DRINKS))
                        .filter(i -> i.getDishType().equals(ItemType.ALCOHOLIC))
                        .findFirst()
                        .orElse(null)));

        table.orderItem(
                Objects.requireNonNull(Objects.requireNonNull(menu)
                        .getDishes().stream()
                        .filter(i -> i.getMenuType().equals(MenuType.DRINKS))
                        .filter(i -> i.getDishType().equals(ItemType.NON_ALCOHOLIC))
                        .findFirst()
                        .orElse(null)));


        /**
         * OH NOO!, you are out of food. You want to place another order for your table.
         * Your task is to order items of your choice with below variety.
         *  a. Order one NON_VEG, LUNCH item which is chef special
         *  b. Order two VEG BRUNCH items which is chef special.
         *  c. Order two restaurant special ALCOHOLIC items.
         * */

        table.orderItem(
                Objects.requireNonNull(Objects.requireNonNull(menu)
                        .getDishes().stream()
                        .filter(i -> i.getMenuType().equals(MenuType.LUNCH))
                        .filter(i -> i.getDishType().equals(ItemType.NON_VEGETERIAN))
                        .filter(MenuItem::getSpeciality)
                        .findFirst()
                        .orElse(null)));

        table.orderMultipleItems(
                Objects.requireNonNull(Objects.requireNonNull(menu)
                        .getDishes().stream()
                        .filter(i -> i.getMenuType().equals(MenuType.BRUNCH))
                        .filter(i -> i.getDishType().equals(ItemType.VEGETERIAN))
                        .filter(MenuItem::getSpeciality)
                        .limit(2L)).collect(Collectors.toList()));

        table.orderMultipleItems(
                Objects.requireNonNull(Objects.requireNonNull(menu)
                        .getDishes().stream()
                        .filter(i -> i.getMenuType().equals(MenuType.DRINKS))
                        .filter(i -> i.getDishType().equals(ItemType.ALCOHOLIC))
                        .filter(MenuItem::getSpeciality)
                        .limit(2L)).collect(Collectors.toList()));

        /**
         * You are fortunate today. Your friends are also dining with us.
         * You now want us to join the two separate tables and arrange the food on the new table.
         * We need your help to carry out this task. Help us write below code in order to merge the two tables.
         * */

        Table friendTable = DataStub.getFriendTableStub(restaurant, 3);

        /**
         * Logical requirements:
         * a. create a new table instance with capacity of combined guest count from two tables.
         * b. make new table available for orders.
         * c. Assign a server to table. Because you have two servers choose the one who can handle more tables.
         * d. move all food items from both table to new table.
         * e. Make the two original table unavailable and clear their food contents and server.
         *
         * f. Once the bill is generated delete this new table and make sure original tables are now available again.
         * g. don't forget to tip our proud server. You need to split the tip amount to 70-30 between original servers.
         * */


    }
}