package test.java;

import main.java.DataStub;
import main.java.Menu;
import main.java.Table;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Objects;

public class TaskOneTest {

    @Test
    public void generateBill() throws CloneNotSupportedException {

        Menu menu = DataStub.getMenu();
        Table table = new Table(1, 3,
                0.0f, Collections.emptyList(),
                Collections.emptyList(), Boolean.TRUE, menu);

        Boolean aBoolean = table.generateBill();
        Float billAmount = table.getBillAmount();

        table.orderItem(Objects.requireNonNull(menu).getDishes().get(0));
        table.orderItem(Objects.requireNonNull(menu).getDishes().get(1));
        table.orderItem(Objects.requireNonNull(menu).getDishes().get(2));
        table.orderItem(Objects.requireNonNull(menu).getDishes().get(3));
        table.orderItem(Objects.requireNonNull(menu).getDishes().get(4));
        table.orderItem(Objects.requireNonNull(menu).getDishes().get(6));

        aBoolean = table.generateBill();
        billAmount = table.getBillAmount();

        assert aBoolean.equals(Boolean.TRUE);
        assert billAmount.equals(113.3f);
    }
}
