package simpleRemoteControl;
public class SimpleRemoteControl {
    protected Command slot;
    public SimpleRemoteControl() {
        slot = null;
    }
    public void setCommand(Command command) {
        slot = command;
    }
    public void buttonWasPressed() {
        slot.execute();
    }
}
