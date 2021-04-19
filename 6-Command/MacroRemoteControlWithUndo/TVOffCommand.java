public class TVOffCommand implements Command {
    protected TV tv;
    public TVOffCommand(TV tv) {
        this.tv = tv;
    }
    @Override
    public void execute() {
        this.tv.off();
    }
    @Override
    public void undo() {
        this.tv.on();
    }
}
