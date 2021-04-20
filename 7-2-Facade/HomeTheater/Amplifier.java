package homeTheater;
public class Amplifier {
    protected String description;
    protected DvdPlayer dvd;
    protected int volume;
    public Amplifier(String description) {
        this.description = description;
        volume = 0;
    }
    public void on() {
        System.out.println(description + " Amplifier on");

    }
    public void off() {
        System.out.println(description + " Amplifier off");

    }
	public void setSurroundSound() {
		System.out.println(description + " Amplifier surround sound on (5 speakers, 1 subwoofer)");
	}
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println(description + " Amplifier sets volume " + volume);
    }
    public void setDvd(DvdPlayer dvd) {
        this.dvd = dvd;
        System.out.println(description + " Amplifier sets DVD player to " + dvd);
    }
    public String toString() {
        return this.description;
    }
}
