public class CeilingFanOnCommand implements Command {
    protected CeilingFan ceilingFan;
    public CeilingFanOnCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }
    @Override
    public void execute() {
        this.ceilingFan.high();
    }
}
