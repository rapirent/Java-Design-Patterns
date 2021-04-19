package pizzaStore;
public class NYStyleClamPizza extends Pizza {
    public NYStyleClamPizza() {
        this.name = "NY Style Clam Pizza";
        this.dough = "Thin Crust";
        this.sauce = "White garlic sauce";
        toppings.add("Calms");
        toppings.add("Grated parmesan cheese");
    }
    @Override
    public void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}
