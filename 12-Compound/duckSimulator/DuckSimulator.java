package duckSimulator;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();

        simulator.simulate(duckFactory);
    }

    protected void simulate(AbstractDuckFactory duckFactory) {
        Quackable redheadDuck = duckFactory.createRubberDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());

        Flock flockOfDucks = new Flock();
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        Flock flockOfMalladDucks = new Flock();
        flockOfMalladDucks.add(duckFactory.createMallardDuck());
        flockOfMalladDucks.add(duckFactory.createMallardDuck());
        flockOfMalladDucks.add(duckFactory.createMallardDuck());
        flockOfMalladDucks.add(duckFactory.createMallardDuck());
        flockOfDucks.add(flockOfMalladDucks);

        System.out.println("\nDuck Simulator: With Observer");

        QuackLogist quacklogist = new QuackLogist();
        flockOfDucks.registerObserver(quacklogist);

        simulate(flockOfDucks);

        System.out.println("\nThe ducks quacked " + QuackCounter.getQuacks() + " times");
    }

    protected void simulate(Quackable duck) {
        duck.quack();
    }
}
