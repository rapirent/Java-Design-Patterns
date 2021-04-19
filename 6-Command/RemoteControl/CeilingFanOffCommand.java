public class CeilingFanOffCommand implements Command {
    protected CeilingFan ceilingFan;
    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }
    @Override
    public void execute() {
        this.ceilingFan.off();
    }
}
