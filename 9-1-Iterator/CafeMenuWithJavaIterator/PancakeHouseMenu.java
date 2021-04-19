import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenu implements Menu {
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
    @Override
    public Iterator<MenuItem> createIterator() {
        //ArrayList已經有iterator()方法ㄉ
        return menuItems.iterator();
    }
}
