public class HomeTheaterTestDrive {
    public static void main(String[] args) {
		Amplifier amp = new Amplifier("Top-O-Line");
		DvdPlayer dvd = new DvdPlayer("Top-O-Line");
		Projector projector = new Projector("Top-O-Line");
		TheaterLights lights = new TheaterLights("Theater Ceiling");
		Screen screen = new Screen("Theater");
		PopcornPopper popper = new PopcornPopper("Popcorn");
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, dvd, projector, screen, lights, popper);
        homeTheater.watchMovie("Raider of the Lost Ark");
        homeTheater.endMovie();
    }
}
