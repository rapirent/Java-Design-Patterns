package starbuzzCoffeeWithSize;
// can use interface also
// Component
public abstract class Beverage {
    protected String description;
    enum Size {TALL, GRANDE, VENTI};
    protected Size size;
    public Beverage() {
        this.description = "Unknown Beverage";
        this.size = Size.TALL;
    }
    public String getDescription() {
        return description;
    }
    public abstract double cost();
    public void setSize(Size size) {
        this.size = size;
    }
    public Size getSize() {
        return size;
    }
}
