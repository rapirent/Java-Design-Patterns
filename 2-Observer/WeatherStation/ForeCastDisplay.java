public class ForeCastDisplay implements Observer, DisplayElement {
    private float currentPressure;
    private float lastPressure;
    private Subject weatherData;

    public ForeCastDisplay(Subject weatherData) {
        currentPressure = 29.92f;
        this.weatherData = weatherData;//這是因為DisplayElement
        weatherData.registerObserver(this);
    }
    @Override
    public void update(float temperature, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;
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
