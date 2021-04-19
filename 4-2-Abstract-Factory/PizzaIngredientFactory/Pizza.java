import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    protected String name = null;
    protected Dough dough = null;
    protected Sauce sauce = null;
    protected Veggies veggies[] = null;
    protected Pepperoni pepperoni = null;
    protected Clams clams = null;
    protected Cheese cheese = null;

    public Pizza() {}

    abstract public void prepare();

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
    public void setName(String name) {
        this.name = name;
    }
    public String toString() {
        //StringBuffer is obsolete
        StringBuilder result = new StringBuilder();
        System.out.println("Preparing " + name);
        System.out.println("Testing dough..." + dough);
        System.out.println("Adding sauce..." + sauce);
        System.out.println("Adding toppings: ");
        if (dough != null) {
            result.append(dough);
            result.append("\n");
        }
        if (sauce != null) {
            result.append(sauce);
            result.append("\n");
        }
        if (cheese != null) {
            result.append(cheese);
            result.append("\n");
        }
        if (veggies != null) {
            for (Veggies v: veggies) {
                result.append(v);
                result.append(" ");
            }
            result.append("\n");
        }
        if (clams != null) {
            result.append(clams);
            result.append("\n");
        }
        if (pepperoni != null) {
            result.append(pepperoni);
            result.append("\n");
        }
        return result.toString();
    }
}
