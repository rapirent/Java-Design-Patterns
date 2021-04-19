public class PopcornPopper {
    protected String description;
    public PopcornPopper(String description) {
        this.description = description;
    }
    public void on() {
        System.out.println(description + " Popper on");
    }
    public void off() {
        System.out.println(description + " Popper off");

    }
    public void pop() {
        System.out.println(description + " Popper is popping");
    }
    public String toString() {
        return this.description;
    }
}
