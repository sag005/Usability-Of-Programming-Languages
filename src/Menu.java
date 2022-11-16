import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuItem> menuItems;

    public Menu(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public ArrayList<MenuItem> getDishes() {
        return menuItems;
    }

    public void setDishes(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

}
