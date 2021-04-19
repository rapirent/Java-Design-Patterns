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
}
