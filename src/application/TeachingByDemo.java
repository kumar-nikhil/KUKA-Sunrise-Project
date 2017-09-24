package application;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import com.kuka.common.ThreadUtil;
import com.kuka.roboticsAPI.applicationModel.RoboticsAPIApplication;
import static com.kuka.roboticsAPI.motionModel.BasicMotions.*;

import com.kuka.roboticsAPI.conditionModel.JointTorqueCondition;
import com.kuka.roboticsAPI.controllerModel.Controller;
import com.kuka.roboticsAPI.deviceModel.JointEnum;
import com.kuka.roboticsAPI.deviceModel.JointPosition;
import com.kuka.roboticsAPI.deviceModel.LBR;
import com.kuka.roboticsAPI.geometricModel.CartDOF;
import com.kuka.roboticsAPI.motionModel.IMotionContainer;
import com.kuka.roboticsAPI.motionModel.controlModeModel.CartesianImpedanceControlMode;
import com.kuka.roboticsAPI.motionModel.controlModeModel.PositionControlMode;
import com.kuka.roboticsAPI.uiModel.ApplicationDialogType;

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
public class TeachingByDemo extends RoboticsAPIApplication {
	@Inject
	private LBR lbr;
	private Controller cabinet;

	@Override
	public void initialize() {
		// initialize your application here
		cabinet = getController("KUKA_Sunrise_Cabinet_1");
		lbr = (LBR) getDevice(cabinet,
				"LBR_iiwa_14_R820_1");
	}

	@Override
	public void run() {
		// your application execution starts here
		//lBR_iiwa_14_R820_1.move(ptpHome());
		teaching();
	}
	
	private void teaching(){
		CartesianImpedanceControlMode mode = new CartesianImpedanceControlMode();
		mode.parametrize(CartDOF.ALL).setStiffness(80);
		mode.parametrize(CartDOF.ROT).setStiffness(10);
		
		double blending = /*getApplicationData().getProcessData("blending").getValue()*/ 0.2;
		int tick = /*getApplicationData().getProcessData("tick").getValue()*/ 500;
		ArrayList<JointPosition> positions = new ArrayList<JointPosition>();
		
		JointTorqueCondition fc = new JointTorqueCondition(JointEnum.J1, -15, 15);
		
		//lbr.move(ptp(0, Math.toRadians(25), 0, Math.toRadians(-85), 0, Math.toRadians(70), 0).setJointVelocityRel(.3).setJointAccelerationRel(.5));
		lbr.move(ptp(getApplicationData().getFrame("/start")).setJointVelocityRel(0.3).setJointAccelerationRel(0.5));
		lbr.move(positionHold(new PositionControlMode(), 1, TimeUnit.SECONDS).breakWhen(fc));
		String startDialog = "Move Robot To Teach Points!";
		getLogger().info(startDialog);
		int time = /*getApplicationData().getProcessData("time").getValue()*/ 20;
		
		IMotionContainer posHold = lbr.moveAsync(positionHold(mode, time, TimeUnit.SECONDS));
		
		ThreadUtil.milliSleep(1000);
		while(!posHold.isFinished()){
			ThreadUtil.milliSleep(tick);
			positions.add(lbr.getCurrentJointPosition());
		}
		
		//ThreadUtil.milliSleep(1000);
		lbr.move(ptp(lbr.getCurrentJointPosition()));
		
		getApplicationUI().displayModalDialog(ApplicationDialogType.INFORMATION, "Replay?", "Replay!");
		int sel = 10;
		while (sel !=1){
			lbr.move(ptp(positions.get(0)).setJointVelocityRel(.3));
			
			double velo = /*getApplicationData().getProcessData("velo").getValue()*/ 0.25;
			double acce = /*getApplicationData().getProcessData("acce").getValue()*/ 0.2;
			double jerk = /*getApplicationData().getProcessData("jerk").getValue()*/ 0.1;
			
			for(int i = 1; i < positions.size(); i++){
				lbr.moveAsync(ptp(positions.get(i)).setBlendingRel(blending).setJointVelocityRel(velo).setJointJerkRel(jerk).setJointAccelerationRel(acce));
			}
			sel = getApplicationUI().displayModalDialog(ApplicationDialogType.QUESTION, "Replay again?", "Replay!", "Close");
		}
				
		lbr.move(ptp(positions.get(0)).setJointVelocityRel(.3));
		
	}
}