package gumballMachineMonitor;
import java.util.Random;

public class HasQuarterState implements State {
    protected Random randomWinner = new Random(System.currentTimeMillis());
    protected GumballMachine gumballMachine = null;
    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }
    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }
    @Override
    public void turnCrank() {
		System.out.println("You turned, but there are no gumballs");
        int winner = randomWinner.nextInt(10);
        if ((winner == 0) && (gumballMachine.getCount() > 1)) {
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }
    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
    @Override
    public void refill() {}

    public String toString() {
		return "waiting for turn of crank";
	}
}
