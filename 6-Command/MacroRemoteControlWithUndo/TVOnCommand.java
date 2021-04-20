package macroRemoteControlWithUndo;
public class TVOnCommand implements Command {
    protected TV tv;
    public TVOnCommand(TV tv) {
        this.tv = tv;
    }
    @Override
    public void execute() {
        this.tv.on();
    }
    @Override
    public void undo() {
        this.tv.off();
    }
}
