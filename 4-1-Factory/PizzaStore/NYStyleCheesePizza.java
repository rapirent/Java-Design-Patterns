public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        this.name = "NY Style Cheese Pizza";
        this.dough = "Regular Crust";
        this.sauce = "Marinara Pizza sauce";
        toppings.add("Fresh Mozzarella");
        toppings.add("Parmesan");
    }
    @Override
    public void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}
