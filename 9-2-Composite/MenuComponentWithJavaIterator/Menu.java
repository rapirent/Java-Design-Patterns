package menuComponentWithJavaIterator;
import java.util.ArrayList;
import java.util.Iterator;

public class Menu extends MenuComponent {
    protected ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
    protected String name = null;
    protected String description = null;
    protected Iterator<MenuComponent> iterator = null;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return (MenuComponent)menuComponents.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void print() {
        System.out.println("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("----------");

        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = (MenuComponent) iterator.next();
            menuComponent.print();
        }
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        // 從sample code上學會的 可以保證iterator只產生一次
        if (iterator == null) {
            iterator =  new CompositeIterator(menuComponents.iterator());
        }
        return iterator;
    }
}
