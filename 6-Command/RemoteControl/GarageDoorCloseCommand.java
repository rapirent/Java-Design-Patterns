package remoteControl;
public class GarageDoorCloseCommand implements Command {
    protected GarageDoor gd;
    public GarageDoorCloseCommand(GarageDoor gd) {
        this.gd = gd;
    }
    @Override
    public void execute() {
        gd.open();
    }
}
