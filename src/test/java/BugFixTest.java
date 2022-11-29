package test.java;

import main.java.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BugFixTest {

    /**
     * Our proud servers are being tipped 10% of the table bill.
     * <p>
     * You are provided with the logical implementation of how a server can check their
     * estimated tip based on the tables they are serving and the food already served or
     * is about to be served. The tip returned is cumulative tip expected from all tables.
     * <p>
     * {@link Restaurant#getEstimatedTipForServer(Server) code}
     * <p>
     * You are provided with one of the servers from our restaurant.
     * The server is not happy with the return estimate of the tip and ask us to revisit the logic.
     * We need you help to find the bug in the logic and fix it.
     * <p>
     * For this task you need to make sure the test runs in the test file.
     */

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

    @Test
    public void testGenerateEstimatedServerTips() {
        Server serverForTipEstimation = DataStub.getServerForTipEstimation(restaurant);
        Double estimatedTipForServer = restaurant.getEstimatedTipForServer(serverForTipEstimation);
        assert estimatedTipForServer.equals(8.627999877929687);
    }

}
