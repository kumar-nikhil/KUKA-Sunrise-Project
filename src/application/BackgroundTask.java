package application;


import javax.inject.Inject;
import java.util.concurrent.TimeUnit;
import com.kuka.roboticsAPI.applicationModel.tasks.CycleBehavior;
import com.kuka.roboticsAPI.applicationModel.tasks.RoboticsAPICyclicBackgroundTask;
import com.kuka.roboticsAPI.controllerModel.Controller;
import com.kuka.generated.ioAccess.*;

/**
 * Implementation of a cyclic background task.
 * <p>
 * It provides the {@link RoboticsAPICyclicBackgroundTask#runCyclic} method 
 * which will be called cyclically with the specified period.<br>
 * Cycle period and initial delay can be set by calling 
 * {@link RoboticsAPICyclicBackgroundTask#initializeCyclic} method in the 
 * {@link RoboticsAPIBackgroundTask#initialize()} method of the inheriting 
 * class.<br>
 * The cyclic background task can be terminated via 
 * {@link RoboticsAPICyclicBackgroundTask#getCyclicFuture()#cancel()} method or 
 * stopping of the task.
 * @see UseRoboticsAPIContext
 * 
 */
public class BackgroundTask extends RoboticsAPICyclicBackgroundTask {
	@Inject
	Controller kUKA_Sunrise_Cabinet_1;
	Nikhil_ioIOGroup cyclic_out;
	
	

	@Override
	public void initialize() {
		// initialize your task here
		initializeCyclic(0, 500, TimeUnit.MILLISECONDS,
				CycleBehavior.BestEffort);
		cyclic_out = new Nikhil_ioIOGroup(kUKA_Sunrise_Cabinet_1);
	}

	@Override
	public void runCyclic() {
		// your task execution starts here
		//boolean state = cyclic_out.getInput1();
		cyclic_out.pulse("OUT1", true, 500);
		
		
	}
}