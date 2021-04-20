package menuWithJavaIterator;
public class MenuTestDrive {
	public static void main(String args[]) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();
		Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
		waitress.printMenu();
        waitress.printBreakfastMenu();
        waitress.printLunchMenu();
        waitress.printVegetarianMenu();
	}
}
