import java.util.ArrayList;

public class Waitress {
    protected Menu pancakeHouseMenu = null;
    protected Menu dinerMenu = null;
    public Waitress(Menu pancakeHouseMenu, Menu dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }
    public void printMenu() {
        Iterator pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator dinerIterator = dinerMenu.createIterator();
        System.out.println("Menu\n----\nBreakfast");
        printMenu(pancakeIterator);
        System.out.println("\nLunch");
        printMenu(dinerIterator);
    }

    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }

    public void printBreakfastMenu() {
        Iterator pancakeIterator = pancakeHouseMenu.createIterator();
        System.out.println("Menu\n----\nBreakfast");
        printMenu(pancakeIterator);
    }

    public void printLunchMenu() {
        Iterator dinerIterator = dinerMenu.createIterator();
        System.out.println("\nLunch");
        printMenu(dinerIterator);
    }

    public void printVegetarianMenu() {
        printVegetarianMenu(pancakeHouseMenu.createIterator());
        printVegetarianMenu(dinerMenu.createIterator());
    }

    private void printVegetarianMenu(Iterator iterator) {
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

    private boolean isItemVegetarian(Iterator iterator, String name) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            if (menuItem.getName().equals(name) && menuItem.isVegetarian()) {
                return true;
            }
        }
        return false;
    }
}
