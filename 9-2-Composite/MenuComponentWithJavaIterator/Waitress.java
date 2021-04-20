package menuComponentWithJavaIterator;
import java.util.ArrayList;
import java.util.Iterator;

public class Waitress {
    protected MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu() {
        allMenus.print();
    }

    public void printVegetarianMenu() {
        Iterator iterator = allMenus.createIterator();
        System.out.println("\nVegetarian Menu\n---");
        while (iterator.hasNext()) {
            MenuComponent menuComponent = (MenuComponent) iterator.next();
            try {
                if (menuComponent.isVegetarian()) {
                    menuComponent.print();
                }
            }
            catch (UnsupportedOperationException e) {

            }
        }
    }
}
