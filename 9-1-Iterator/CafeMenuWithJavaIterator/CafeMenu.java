package cafeMenuWithJavaIterator;
import java.util.Hashtable;
import java.util.Iterator;

public class CafeMenu implements Menu{
    Hashtable<String, MenuItem> menuItems = new Hashtable<String, MenuItem>();

    public CafeMenu() {
        addItem("Veggie Burger and Air Fries",
                "Veggie burger on a whole wheat bun, lettuce, tomato, and fries", true, 3.99);
        addItem("Soup of the day",
                "A cup of the soup of the day, with a side salad", false, 3.68);
        addItem("Burrito",
                "A large burrito, with whole pinto beans, salsa, guacamole", true, 4.29);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.put(menuItem.getName(), menuItem);
    }

    public Iterator<MenuItem> createIterator() {
        // hash table 分為key 和value 我們先取出值再拿迭代器
        return menuItems.values().iterator();
    }
}
