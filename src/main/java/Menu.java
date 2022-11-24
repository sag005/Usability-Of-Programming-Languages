package main.java;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> menuItems;

    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public List<MenuItem> getDishes() {
        return menuItems;
    }

    public void setDishes(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

}
