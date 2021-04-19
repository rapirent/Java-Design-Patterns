package weatherStationObservable;
import java.util.Observer;
import java.util.Observable;

public class ForeCastDisplay implements Observer, DisplayElement {
    Observable observable;
    private float currentPressure;
    private float lastPressure;

    public ForeCastDisplay(Observable observable) {
        currentPressure = 29.92f;
        this.observable = observable;
        observable.addObserver(this);
    }
    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) obs;
            lastPressure = currentPressure;
            currentPressure = weatherData.getPressure();
        }
        display();
    }
    @Override
    public void display() {
        System.out.print("ForeCast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving Weather!");
        } else if (currentPressure == lastPressure){
            System.out.println("More of the same");
        } else {
            System.out.println("rainy weather");
        }
    }
}
