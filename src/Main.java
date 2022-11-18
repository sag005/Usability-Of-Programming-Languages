import java.util.List;

public class Main {
    public static void main(String[] args) {

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
                new Chef(null, 3.0f, 3.7f),
                menu,
                all_servers,
                all_tables
        );

        Table table = restaurant.getTable(5);


    }
}