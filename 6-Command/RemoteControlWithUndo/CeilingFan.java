package remoteControlWithUndo;
public class CeilingFan {
	protected String location;

    enum Level {HIGH, MEDIUM, LOW, CLOSE};
    protected Level level;
	public CeilingFan(String location) {
		this.location = location;
        this.level = Level.CLOSE;
	}

	public void high() {
        this.level = Level.HIGH;
		System.out.println(location + " ceiling fan is on high");
	}

	public void medium() {
        this.level = Level.MEDIUM;
		System.out.println(location + " ceiling fan is on medium");
	}

	public void low() {
        this.level = Level.LOW;
		System.out.println(location + " ceiling fan is on low");
	}

	public void off() {
        this.level = Level.CLOSE;
		System.out.println(location + " ceiling fan is off");
	}

}
