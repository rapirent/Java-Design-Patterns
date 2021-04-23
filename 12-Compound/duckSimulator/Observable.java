package duckSimulator;
import java.util.ArrayList;
public class Observable implements QuackObservable {
    private ArrayList<Observer> observers = null;
    private QuackObservable duck = null;

    public Observable(QuackObservable duck) {
        this.duck = duck;
        this.observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: observers) {
            observer.update(duck);
        }
    }
}
