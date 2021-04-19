package gumballMachineRemoteMonitor;
import java.rmi.Naming;
public class GumballMachineTestDrive {
	public static void main(String[] args) {
        int count = 0;
		GumballMachineRemote gumballMachine = null;
        if (args.length < 2) {
            System.out.println("GumballMachine <name> <inventory>");
            System.exit(1);
        }
        try {
            count = Integer.parseInt(args[1]);
            gumballMachine = new GumballMachine(args[0], count);
            Naming.rebind("//" + args[0] + "/gumballmachine", gumballMachine);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
