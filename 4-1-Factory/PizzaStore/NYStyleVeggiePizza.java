package pizzaStore;
public class NYStyleVeggiePizza extends Pizza {
    public NYStyleVeggiePizza() {
        this.name = "NY Style Veggie Pizza";
        this.dough = "Crust";
        this.sauce = "Marinara sauce";
        toppings.add("Shredded mozzarella");
        toppings.add("Grated parmesan cheese");
        toppings.add("Diced Onion");
        toppings.add("Sliced mushrooms");
        toppings.add("Sliced red pepper");
        toppings.add("Sliced black olives");
    }
    @Override
    public void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}
