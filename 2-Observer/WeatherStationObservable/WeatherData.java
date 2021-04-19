import java.util.Observable;
import java.util.Observer;

// Observable and Observer is deprecated in Java SE 9
// the default java Observable is a class not interface
public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;
    public WeatherData() {}
    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
    public float getTemperature() {
        return this.temperature;
    }
    public float getHumidity() {
        return this.humidity;
    }
    public float getPressure() {
        return this.pressure;
    }
}
