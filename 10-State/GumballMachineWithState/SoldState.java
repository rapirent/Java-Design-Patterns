package gumballMachineWithState;
public class SoldState implements State {
    protected GumballMachine gumballMachine = null;
    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    }
    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }
    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball!");
    }
    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("A gumball comes rolling out the slot");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
    @Override
    public void refill() {}

    public String toString() {
		return "dispensing a gumball";
	}
}
