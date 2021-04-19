public class NYStylePepperoniPizza extends Pizza {
    public NYStylePepperoniPizza() {
        this.name = "NY Style Pepperoni Pizza";
        this.dough = "Crust";
        this.sauce = "Marinara sauce";
        toppings.add("Sliced Pepperoni");
        toppings.add("Sliced Onion");
        toppings.add("Grated parmesan cheese");
    }
    @Override
    public void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}
