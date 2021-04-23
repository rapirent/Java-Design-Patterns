package duckSimulator;

import java.util.ArrayList;

//composite
public class Flock implements Quackable {
    protected ArrayList<Quackable> quackers = new ArrayList<Quackable>();

    public void add (Quackable quacker) {
        quackers.add(quacker);
    }

    @Override
    public void quack() {
        for (Quackable quacker: quackers) {
            quacker.quack();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        for(Quackable quacker: quackers) {
            quacker.registerObserver(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for(Quackable quacker: quackers) {
            quacker.notifyObservers();
        }
    }

    public String toString() {
        return "Duck Flock";
    }
}
