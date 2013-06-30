//Andrew Shay
//http://shayConcepts.com
//v1.0.0
//Changes:
import javax.swing.JOptionPane;


public class States {
	
    public static void Sleepy() {

        try {  	
        	//These are the commands that need to run to sleep. Disable hibernate, then sleep
        	ProcessBuilder pbHibOff = new ProcessBuilder("cmd.exe","/C","powercfg -hibernate off && rundll32.exe powrprof.dll,SetSuspendState 0,1,0");
        	pbHibOff.start();
    	
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null,
			        "Failed to Sleep: " + e,
			        "Error",
			        JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void Hibernate() {

        try {
        	//Commands to Hibernate. Enable hibernate, then hibernate
        	ProcessBuilder pbHibOn = new ProcessBuilder("cmd.exe","/C","powercfg -hibernate on && rundll32.exe powrprof.dll,SetSuspendState Hibernate");
        	pbHibOn.start();
        	
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null,
			        "Failed to Hibernate: " + e,
			        "Error",
			        JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void ShutDown() {

        try {
        	//Command to shutdown PC
        	ProcessBuilder pbShutDown = new ProcessBuilder("cmd.exe","/C","shutdown /s /t 0");
        	pbShutDown.start();
          
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null,
			        "Failed to ShutDown: " + e,
			        "Error",
			        JOptionPane.ERROR_MESSAGE);
        }
    }
}
