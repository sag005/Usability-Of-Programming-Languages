import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataStub {

    public static Menu getMenu() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<MenuItem> menuItems = mapper.readValue(Paths.get("MenuItems.json").toString(), new TypeReference<List<MenuItem>>() {
            });
            return new Menu(menuItems);
        } catch (JsonProcessingException e) {
            System.out.println("haha");
        }
        return null;
    }

    public static List<Table> getTables() {
        List<Table> all_tables = new ArrayList<>();
        all_tables.add(new Table(1, 3, 0.0f, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Boolean.TRUE, getMenu()));
        all_tables.add(new Table(2, 4, 0.0f, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Boolean.TRUE, getMenu()));
        all_tables.add(new Table(3, 2, 0.0f, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Boolean.TRUE, getMenu()));
        all_tables.add(new Table(4, 6, 0.0f, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Boolean.TRUE, getMenu()));
        all_tables.add(new Table(5, 2, 0.0f, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Boolean.TRUE, getMenu()));
        all_tables.add(new Table(6, 3, 0.0f, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Boolean.TRUE, getMenu()));
        all_tables.add(new Table(7, 3, 0.0f, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Boolean.TRUE, getMenu()));
        all_tables.add(new Table(8, 4, 0.0f, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Boolean.TRUE, getMenu()));
        all_tables.add(new Table(9, 2, 0.0f, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Boolean.TRUE, getMenu()));
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
}
