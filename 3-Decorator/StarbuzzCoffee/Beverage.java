package starbuzzCoffee;
// can use interface also
// Component
public abstract class Beverage {
    protected String description;
    public Beverage() {
        this.description = "Unknown Beverage";
    }
    public String getDescription() {
        return description;
    }
    public abstract double cost();
}
