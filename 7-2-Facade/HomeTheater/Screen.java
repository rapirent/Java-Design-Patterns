public class Screen {
    protected String description;
    public Screen(String description) {
        this.description = description;
    }
    public void down() {
        System.out.println(description + " Screen is going down");
    }
    public void up() {
        System.out.println(description + " Screen is going up");

    }
    public String toString() {
        return this.description;
    }
}
