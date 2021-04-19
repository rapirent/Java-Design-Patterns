public class TheaterLights {
    protected String description;
    protected int level;
    public TheaterLights(String description) {
        this.description = description;
        this.level = 100;
    }
    public void on() {
        System.out.println(description + " Lights on");
    }
    public void off() {
        System.out.println(description + " Lights off");

    }
    public void dim(int level) {
        this.level = level;
        System.out.println(description + " Lights is dimming to " + level + "%");
    }
    public String toString() {
        return this.description;
    }
}
