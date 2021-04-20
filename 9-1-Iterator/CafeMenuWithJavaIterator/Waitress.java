package cafeMenuWithJavaIterator;
import java.util.ArrayList;
import java.util.Iterator;

public class Waitress {
    protected Menu pancakeHouseMenu = null;
    protected Menu dinerMenu = null;
    protected Menu cafeMenu = null;
    public Waitress(Menu pancakeHouseMenu, Menu dinerMenu, Menu cafeMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
        this.cafeMenu = cafeMenu;
    }
    public void printMenu() {
        Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();
        Iterator<MenuItem> cafeIterator = cafeMenu.createIterator();
        System.out.println("Menu\n----\nBreakfast");
        printMenu(pancakeIterator);
        System.out.println("\nLunch");
        printMenu(dinerIterator);
        System.out.println("\nDinner");
        printMenu(cafeIterator);
    }

    private void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }

    public void printBreakfastMenu() {
        Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
        System.out.println("Menu\n----\nBreakfast");
        printMenu(pancakeIterator);
    }

    public void printLunchMenu() {
        Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();
        System.out.println("\nLunch");
        printMenu(dinerIterator);
    }

    public void printDinnerMenu() {
        Iterator<MenuItem> cafeIterator = cafeMenu.createIterator();
        System.out.println("\nDinner");
        printMenu(cafeIterator);
    }

    public void printVegetarianMenu() {
        printVegetarianMenu(pancakeHouseMenu.createIterator());
        printVegetarianMenu(dinerMenu.createIterator());
        printVegetarianMenu(cafeMenu.createIterator());
    }

    private void printVegetarianMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            if (menuItem.isVegetarian()) {
                System.out.print(menuItem.getName() + ", ");
                System.out.print(menuItem.getPrice() + " -- ");
                System.out.println(menuItem.getDescription());
            }
        }
    }

    public boolean isItemVegetarian(String name) {
        if (isItemVegetarian(pancakeHouseMenu.createIterator(), name)) {
            return true;
        }

        if (isItemVegetarian(dinerMenu.createIterator(), name)) {
            return true;
        }

        return false;
    }

    private boolean isItemVegetarian(Iterator<MenuItem> iterator, String name) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            if (menuItem.getName().equals(name) && menuItem.isVegetarian()) {
                return true;
            }
        }
        return false;
    }
}
