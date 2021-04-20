package menuWithIterator;
import java.util.ArrayList;

public class Waitress {
    protected PancakeHouseMenu pancakeHouseMenu = null;
    protected DinerMenu dinerMenu = null;
    //不像書中的代碼，（至少）SE5使用範型時得寫出型別而可進行型別檢查
    //ref:
    //https://stackoverflow.com/questions/14207005/warning-arraylist-is-a-raw-type-references-to-generic-type-arrayliste-should
    protected ArrayList<MenuItem> breakfastItems = null;
    protected MenuItem[] lunchItems = null;
    public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
        this.breakfastItems = pancakeHouseMenu.getMenuItems();
        this.lunchItems = dinerMenu.getMenuItems();
    }
    public void printMenu() {
        for(int i = 0; i <breakfastItems.size(); i++) {
            MenuItem menuItem = (MenuItem) breakfastItems.get(i);
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }


        for(int i = 0; i <lunchItems.length; i++) {
            MenuItem menuItem = lunchItems[i];
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }

    public void printBreakfastMenu() {
        for(int i = 0; i <breakfastItems.size(); i++) {
            MenuItem menuItem = (MenuItem) breakfastItems.get(i);
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }

    public void printLunchMenu() {
        for(int i = 0; i <lunchItems.length; i++) {
            MenuItem menuItem = lunchItems[i];
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }

    public void printVegetarianMenu() {
        for(int i = 0; i <breakfastItems.size(); i++) {
            MenuItem menuItem = (MenuItem) breakfastItems.get(i);
            if (menuItem.isVegetarian()) {
                System.out.print(menuItem.getName() + ", ");
                System.out.print(menuItem.getPrice() + " -- ");
                System.out.println(menuItem.getDescription());
            }
        }


        for(int i = 0; i <lunchItems.length; i++) {
            MenuItem menuItem = lunchItems[i];
            if (menuItem.isVegetarian()) {
                System.out.print(menuItem.getName() + ", ");
                System.out.print(menuItem.getPrice() + " -- ");
                System.out.println(menuItem.getDescription());
            }
        }
    }

    public boolean isItemVegetarian(String name) {
        for(int i = 0; i <breakfastItems.size(); i++) {
            MenuItem menuItem = (MenuItem) breakfastItems.get(i);
            if (menuItem.getName().equals(name) && menuItem.isVegetarian()) {
                return true;
            }
        }


        for(int i = 0; i <lunchItems.length; i++) {
            MenuItem menuItem = lunchItems[i];
            if (menuItem.getName().equals(name) && menuItem.isVegetarian()) {
                return true;
            }
        }
		return false;
    }
}
