package remoteControl;
public class GarageDoorOpenCommand implements Command {
    protected GarageDoor gd;
    public GarageDoorOpenCommand(GarageDoor gd) {
        this.gd = gd;
    }
    @Override
    public void execute() {
        gd.open();
    }
}
