package duckSimulator;
//decorator
public class QuackCounter implements Quackable {
    private static int count = 0;
    protected Quackable duck = null;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();
        count++;
    }

    public static int getQuacks() {
        return count;
    }

    @Override
    public void registerObserver(Observer observer) {
        this.duck.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        this.duck.notifyObservers();
    }

    public String toString() {
        return this.duck.toString();
    }
}
