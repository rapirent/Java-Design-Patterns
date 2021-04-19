import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {
    private float maxTemp;
    private float minTemp;
    private float tempSum;
    private int numReadings;
    Observable observable;

    public StatisticsDisplay(Observable observable) {
        maxTemp = 0.0f;
        minTemp = 200;
        tempSum = 0.0f;
        this.observable = observable;
        observable.addObserver(this);
    }
    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) obs;
            tempSum += weatherData.getTemperature();
            numReadings++;
            if (tempSum > maxTemp) {
                maxTemp = weatherData.getTemperature();
            } else {
                minTemp = weatherData.getTemperature();
            }
        }
        display();
    }
    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
    }
}
