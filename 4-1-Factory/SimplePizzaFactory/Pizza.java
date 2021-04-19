package simplePizzaFactory;
import java.util.ArrayList;
import java.util.List;

public class Pizza {
    protected String name;
    protected String dough;
    protected String sauce;
    protected List<String> toppings;

    public Pizza() {
        this.toppings = new ArrayList<>();
    }

    public void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Testing dough..." + dough);
        System.out.println("Adding sauce..." + sauce);
        System.out.println("Adding toppings: ");
        for(String t: toppings) {
            System.out.println("  " + t);
        }
    }

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place Pizza in official PizzaStore box");
    }
    public String getName() {
        return name;
    }
}
