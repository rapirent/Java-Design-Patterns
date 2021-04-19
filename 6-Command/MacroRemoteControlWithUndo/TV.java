public class TV {
	protected String location;

	public TV(String location) {
		this.location = location;
	}

	public void on() {
		System.out.println(location + " tv is on");
	}

	public void off() {
		System.out.println(location + " tv is off");
	}

}
