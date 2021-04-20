package macroRemoteControlWithUndo;
public class HottubOffCommand implements Command {
    protected Hottub hottub;
    public HottubOffCommand(Hottub hottub) {
        this.hottub = hottub;
    }
    @Override
    public void execute() {
        this.hottub.off();
    }
    @Override
    public void undo() {
        this.hottub.on();
    }
}
