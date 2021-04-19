package gumballMachineRemoteMonitor;
import java.rmi.*;

public class GumballMonitorTestDrive {
    public static void main(String[] args) {
        String location = "rmi://127.0.0.1/gumballmachine";

        GumballMonitor monitor = null;
        GumballMachineRemote machine = null;
        try {
            machine = (GumballMachineRemote) Naming.lookup(location);
            monitor = new GumballMonitor(machine);
            System.out.println(monitor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        monitor.report();
    }
}
