package homeTheater;
public class DvdPlayer {
    protected String description;
    protected String title;
    public DvdPlayer(String description) {
        this.description = description;
    }
    public void on() {
        System.out.println(description + " Dvd Player on");
    }
    public void off() {
        System.out.println(description + " Dvd Player off");

    }
    public void play(String title) {
        this.title = title;
        System.out.println(description + " Dvd Player is playing \"" + title + "\"");
    }
    public void stop() {
        System.out.println(description + " Dvd Player stopped \"" + title + "\"");
	}
    public void eject() {
        System.out.println(description + " Dvd Player ejected");
    }
    public String toString() {
        return this.description;
    }
}
