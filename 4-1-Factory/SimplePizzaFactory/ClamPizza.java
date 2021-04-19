package simplePizzaFactory;
public class ClamPizza extends Pizza {
    public ClamPizza() {
        this.name = "Clam Pizza";
        this.dough = "Thin Crust";
        this.sauce = "White garlic sauce";
        toppings.add("Calms");
        toppings.add("Grated parmesan cheese");
    }
}
