//Andrew Shay
//http://shayConcepts.com
//v1.0.0
//Changes:
import java.util.TimerTask;

public class SetTime extends TimerTask {

public void run() {
    if(Main.getState() == 1){
    	States.Sleepy();	
    }
    
    else if(Main.getState() == 2){
    	States.Hibernate();	
    }
    
    else if(Main.getState() == 3){
    	States.ShutDown();
    }
  }

}