import java.util.ArrayList;

public class Chef {

    private final ArrayList<MenuItem> menuItems;
    private final float experience_in_years;
    private float ratings;

    public Chef(ArrayList<MenuItem> menuItems, float experience_in_years, float ratings) {
        this.menuItems = menuItems;
        this.experience_in_years = experience_in_years;
        this.ratings = ratings;
    }

    public ArrayList<MenuItem> getDishes() {
        return menuItems;
    }

    public float getExperience_in_years() {
        return experience_in_years;
    }

    public float getRatings() {
        return ratings;
    }

    public void setRatings(float ratings) {
        this.ratings = ratings;
    }


}
