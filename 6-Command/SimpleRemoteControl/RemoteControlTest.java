public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl src = new SimpleRemoteControl();
        Light light = new Light();
        GarageDoor gd = new GarageDoor();
        LightOnCommand lightOn = new LightOnCommand(light);
        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(gd);
        src.setCommand(lightOn);
        src.buttonWasPressed();
        src.setCommand(garageDoorOpen);
        src.buttonWasPressed();
    }
}
