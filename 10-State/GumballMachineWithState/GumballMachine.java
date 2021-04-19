public class GumballMachine {
    protected State soldOutState = null;
    protected State noQuarterState = null;
    protected State hasQuarterState = null;
    protected State winnerState = null;
    protected State soldState = null;
    protected State state = null;
    protected int count = 0;
    public GumballMachine(int count) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        state = soldState;
        if (count > 0) {
            state = noQuarterState;
        }
        this.count = count;
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

	public void ejectQuarter() {
        state.ejectQuarter();
	}

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
	}

    public void setState(State state) {
        this.state = state;
    }

    public int getCount() {
        return count;
    }

    public void releaseBall() { System.out.println("A gumball comes rolling out the slot");
        if (this.count > 0) {
            this.count = this.count - 1;
        }
    }

	public void refill(int numGumBalls) {
		this.count += numGumBalls;
		System.out.println("The gumball machine was just refilled; its new count is: " + this.count);
        state.refill();
	}

    public State getState() {
        return state;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

	public String toString() {
        StringBuilder result = new StringBuilder();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004\n");
		result.append("Inventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\nMachine is " + state + "\n");
		return result.toString();
	}
}
