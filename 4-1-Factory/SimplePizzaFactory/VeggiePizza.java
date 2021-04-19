package simplePizzaFactory;
public class VeggiePizza extends Pizza {
    public VeggiePizza() {
        this.name = "Veggie Pizza";
        this.dough = "Crust";
        this.sauce = "Marinara sauce";
        toppings.add("Shredded mozzarella");
        toppings.add("Grated parmesan cheese");
        toppings.add("Diced Onion");
        toppings.add("Sliced mushrooms");
        toppings.add("Sliced red pepper");
        toppings.add("Sliced black olives");
    }
}
