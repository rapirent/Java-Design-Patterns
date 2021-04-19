package weatherStation;

public class StatisticsDisplay implements Observer, DisplayElement {
    private float maxTemp;
    private float minTemp;
    private float tempSum;
    private int numReadings;
    private Subject weatherData;

    public StatisticsDisplay(Subject weatherData) {
        maxTemp = 0.0f;
        minTemp = 200;
        tempSum = 0.0f;
        this.weatherData = weatherData;//這是因為DisplayElement
        weatherData.registerObserver(this);
    }
    @Override
    public void update(float temperature, float humidity, float pressure) {
        tempSum += temperature;
        numReadings++;
        if (tempSum > maxTemp) {
            maxTemp = temperature;
        } else {
            minTemp = temperature;
        }
        display();
    }
    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
    }
}
