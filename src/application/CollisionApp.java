package application;


import javax.inject.Inject;

import com.kuka.common.ThreadUtil;
import com.kuka.roboticsAPI.applicationModel.RoboticsAPIApplication;
import static com.kuka.roboticsAPI.motionModel.BasicMotions.*;

import com.kuka.roboticsAPI.conditionModel.ConditionObserver;
import com.kuka.roboticsAPI.conditionModel.IAnyEdgeListener;
import com.kuka.roboticsAPI.conditionModel.ICondition;
import com.kuka.roboticsAPI.conditionModel.JointTorqueCondition;
import com.kuka.roboticsAPI.conditionModel.NotificationType;
import com.kuka.roboticsAPI.controllerModel.Controller;
import com.kuka.roboticsAPI.controllerModel.sunrise.ResumeMode;
import com.kuka.roboticsAPI.controllerModel.sunrise.SunriseExecutionService;
import com.kuka.roboticsAPI.deviceModel.JointEnum;
import com.kuka.roboticsAPI.deviceModel.LBR;
import com.kuka.roboticsAPI.deviceModel.OperationMode;

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
public class CollisionApp extends RoboticsAPIApplication {
	@Inject
	private LBR lbr;
	private Controller cabinet;
	private IAnyEdgeListener stop;
	private final int GREY_TORQUE = 15;
	private JointTorqueCondition joint1, joint2, joint3, joint4, joint5, joint6, joint7;
	private ICondition collisionNormal;
	private ConditionObserver normalObserver;

	@Override
	public void initialize() {
		// initialize your application here
		cabinet = getController("KUKA_Sunrise_Cabinet_1");
		lbr = (LBR) getDevice(cabinet,
				"LBR_iiwa_14_R820_1");
		
		// initialize your application here
		// Conditions for the gray collision monitoring on an open road
        joint1 = new JointTorqueCondition(lbr, JointEnum.J1, -GREY_TORQUE, GREY_TORQUE);
        joint2 = new JointTorqueCondition(lbr, JointEnum.J2, -GREY_TORQUE, GREY_TORQUE);
        joint3 = new JointTorqueCondition(lbr, JointEnum.J3, -GREY_TORQUE, GREY_TORQUE);
        joint4 = new JointTorqueCondition(lbr, JointEnum.J4, -GREY_TORQUE, GREY_TORQUE);
        joint5 = new JointTorqueCondition(lbr, JointEnum.J5, -GREY_TORQUE, GREY_TORQUE);
        joint6 = new JointTorqueCondition(lbr, JointEnum.J6, -GREY_TORQUE, GREY_TORQUE);
        joint7 = new JointTorqueCondition(lbr, JointEnum.J7, -GREY_TORQUE, GREY_TORQUE);
        
     // Combined Conditions for collision monitoring on an open road and in processes
        collisionNormal = joint1.or(joint2, joint3, joint4, joint5, joint6, joint7);

		// Listeners to pause and resume the application independent
		stop = new IAnyEdgeListener() 
		{               
			// Input parameters of the listener method:
			// 	conditionObserver:	Object notified by the listener.
			//	time:				Date and time the listener was notified.
			// 	missedEvents: 		Number of changes in state which have occurred but not been handled.
			//	conditionValue: 	Specifies the edge via which the method was called, true= rising edge, false= falling edge.
			@Override
			public void onAnyEdge(ConditionObserver conditionObserver,java.util.Date time, int missedEvents, boolean conditionValue) 
			{
				// Process Date specifies whether an application pause was taken by the collision monitoring
				// Application should not be continued if the break was pressed by the operator

				// Pause upon collision the application if it is not already paused
				if (conditionValue == true && !((SunriseExecutionService) cabinet.getExecutionService()).isPaused())
				{
					
					if (conditionObserver.equals(normalObserver))
					{
						System.out.println("Free collision detected");
					}

					((SunriseExecutionService) cabinet.getExecutionService()).startPause(); // pause movement
				}
				// Resume application after 2 seconds after the collision is gone and was when paused by collision
				else if (conditionValue == false  && ((SunriseExecutionService) cabinet.getExecutionService()).isPaused())
				{
					ThreadUtil.milliSleep(3000);
					
					if (lbr.getOperationMode() == /*OperationMode.AUT*/OperationMode.T1)
					{
						((SunriseExecutionService) cabinet.getExecutionService()).resumeExecution(ResumeMode.OnPath); // resume movement
					}
				}
			}
		};

		// Create Observer for collision monitoring
		normalObserver = getObserverManager().createConditionObserver(collisionNormal, NotificationType.OnEnable, stop);


	}

	@Override
	public void run() {
		// your application execution starts here
		//lbr.move(ptpHome());
		// abilitazione collisione
		normalObserver.enable();
		
		while(true){
			lbr.moveAsync(ptp(getApplicationData().getFrame("/P1")).setBlendingCart(10));
			lbr.moveAsync(ptp(getApplicationData().getFrame("/P2")).setBlendingCart(10));
			lbr.moveAsync(ptp(getApplicationData().getFrame("/P3")).setBlendingCart(10));
		}
	}
}