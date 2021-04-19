import java.util.ArrayList;

public class PancakeHouseMenu {
    protected ArrayList<MenuItem> menuItems;

    public PancakeHouseMenu() {
        this.menuItems = new ArrayList<MenuItem>();
        addItem("K&B's Pancake Breakfast", "Pancake with scrambled eggs, and taost", true, 2.99);
        addItem("Regular Pancake Breakfast", "Pancake with fried eggs, and sausage", false, 2.99);
        addItem("Blueberry Pancake Breakfast", "Pancake with fresh blueberries", true, 3.49);
        addItem("Waffles", "Waffles", true, 3.59);
    }
    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }
    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }
}
