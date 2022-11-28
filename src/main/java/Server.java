package main.java;

import java.util.HashMap;
import java.util.Map;

public class Server {


    private Map<Integer, Tip> tableServing = new HashMap<>();
    private final int servingCapacity;


    public Server(int servingCapacity) {
        this.servingCapacity = servingCapacity;
    }

    public Map<Integer, Tip> getTableServing() {
        return tableServing;
    }

    public void setTipsPerTable(Map<Integer, Tip> tableServing) {
        this.tableServing = tableServing;
    }

    public int getServingCapacity() {
        return servingCapacity;
    }

}
