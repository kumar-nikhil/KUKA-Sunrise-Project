package application;


import javax.inject.Inject;
import com.kuka.roboticsAPI.applicationModel.RoboticsAPIApplication;
import static com.kuka.roboticsAPI.motionModel.BasicMotions.*;

import com.kuka.roboticsAPI.controllerModel.Controller;
import com.kuka.roboticsAPI.deviceModel.LBR;
import com.kuka.roboticsAPI.uiModel.ApplicationDialogType;
import com.kuka.generated.ioAccess.*;
import static com.kuka.roboticsAPI.motionModel.HRCMotions.*;

/**
 * Implementation of a robot application.
 * <p>
 * The application provides a {@link RoboticsAPITask#initialize()} and a 
 * {@link RoboticsAPITask#run()} method, which will be called successively in 
 * the application lifecycle. The application will terminate automatically after 
 * the {@link RoboticsAPITask#run()} method has finished or after stopping the 
 * task. The {@link RoboticsAPITask#dispose()} method will be called, even if an 
 * exception is thrown during initialization or run. 
 * <p>
 * <b>It is imperative to call <code>super.dispose()</code> when overriding the 
 * {@link RoboticsAPITask#dispose()} method.</b> 
 * 
 * @see UseRoboticsAPIContext
 * @see #initialize()
 * @see #run()
 * @see #dispose()
 */
public class RobotApplication extends RoboticsAPIApplication {
	@Inject
	private LBR robot;
	private Controller controller;
	private Nikhil_ioIOGroup gripper;
	@Override
	public void initialize() {
		// initialize your application here
		controller = getController("KUKA_Sunrise_Cabinet_1");
		robot = (LBR) getDevice(controller,
				"LBR_iiwa_14_R820_1");
		gripper = new Nikhil_ioIOGroup(controller);
		
		
	}

	@Override
	public void run() {
		// your application execution starts here
		robot.move(ptpHome());
		gripper.setGripper_open(false);
		int decision = getApplicationUI().displayModalDialog(ApplicationDialogType.QUESTION,"Do you want to switch to gripper?", "Yes", "No");
		if(decision == 0){
		gripper.setGripper_open(true);
		}
		else {
			gripper.setGripper_open(false);
			
			return;
		}
		}
	
	
	
}