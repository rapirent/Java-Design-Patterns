public class Projector {
    protected String description;
    public Projector(String description) {
        this.description = description;
    }
    public void on() {
        System.out.println(description + " Projector on");
    }
    public void off() {
        System.out.println(description + " Projector off");

    }
    public void wideScreenMode() {
        System.out.println(description + " Projector in widescreen mode (16x9 aspect ratio)");
    }
    public String toString() {
        return this.description;
    }
}
