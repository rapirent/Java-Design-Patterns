package duckSimulator;
public class DuckCall implements Quackable {
    protected Observable observable = null;
    public DuckCall() {
        this.observable = new Observable(this);
    }
    @Override
    public void quack() {
        System.out.println("Kwak");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        this.observable.notifyObservers();
    }

    public String toString() {
        return "DuckCall";
    }
}
