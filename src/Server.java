import java.util.ArrayList;

public class Server {

    private final ArrayList<Table> tableServing;
    private float tipAccumulated;

    public Server(ArrayList<Table> tableServing, float tipAccumulated) {
        this.tableServing = tableServing;
        this.tipAccumulated = tipAccumulated;
    }

    public ArrayList<Table> getTableServing() {
        return tableServing;
    }

    public float getTipAccumulated() {
        return tipAccumulated;
    }

    public void setTipAccumulated(float tipAccumulated) {
        this.tipAccumulated = tipAccumulated;
    }
}
