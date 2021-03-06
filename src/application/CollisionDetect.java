package application;


import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import com.kuka.roboticsAPI.applicationModel.RoboticsAPIApplication;
import static com.kuka.roboticsAPI.motionModel.BasicMotions.*;

import com.kuka.roboticsAPI.conditionModel.ICondition;
import com.kuka.roboticsAPI.conditionModel.JointTorqueCondition;
import com.kuka.roboticsAPI.controllerModel.Controller;
import com.kuka.roboticsAPI.deviceModel.JointEnum;
import com.kuka.roboticsAPI.deviceModel.LBR;
import com.kuka.roboticsAPI.geometricModel.CartDOF;
import com.kuka.roboticsAPI.motionModel.IMotionContainer;
import com.kuka.roboticsAPI.motionModel.Spline;
import com.kuka.roboticsAPI.motionModel.controlModeModel.CartesianImpedanceControlMode;
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
public class CollisionDetect extends RoboticsAPIApplication {
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
		collisionDetection(4);
		
	}
	
	private void collisionDetection(int runs) {
		getLogger().info("Collision Detection");
		
		//Abbruchbedingung f�r eine Kollision in grauer Technik
		ICondition forceCon = defineSensitivity();
		
		//Bewegungsprogrammierung
		Spline liegendeAcht = new Spline(
			spl(getFrame("/start/P2")), spl(getFrame("/start/P3")),
			spl(getFrame("/start/P1")), spl(getFrame("/start/P4")),
			spl(getFrame("/start/P5")), spl(getFrame("/start/P1")),
			spl(getFrame("/start/P2")), spl(getFrame("/start/P3")),
			spl(getFrame("/start/P1")), spl(getFrame("/start/P4")),
			spl(getFrame("/start/P5")), spl(getFrame("/start/P1"))
		).setCartVelocity(150).breakWhen(forceCon);
		
		IMotionContainer motion;
		for (int i = 0; i < runs; i++) {
			motion = lbr.move(liegendeAcht);
			if (motion.hasFired(forceCon)) {
				//Reaktion auf Kollision
				boolean resumeMotion = behaviourAfterCollision();
				if (!resumeMotion) break;
			}
		}
	}
	
	private ICondition defineSensitivity() {
		//double threshold = getApplicationData().getProcessData("threshold").getValue();
		int threshold = 10;
		getLogger().info("Sensitivity of each axis: " +threshold + " Nm\nCan be changed in Process data.");
		
		
		//Offsetkompensation
		double actTJ1 = lbr.getExternalTorque().getSingleTorqueValue(JointEnum.J1);
		double actTJ2 = lbr.getExternalTorque().getSingleTorqueValue(JointEnum.J2);
		double actTJ3 = lbr.getExternalTorque().getSingleTorqueValue(JointEnum.J3);
		double actTJ4 = lbr.getExternalTorque().getSingleTorqueValue(JointEnum.J4);
		double actTJ5 = lbr.getExternalTorque().getSingleTorqueValue(JointEnum.J5);
		double actTJ6 = lbr.getExternalTorque().getSingleTorqueValue(JointEnum.J6);
		double actTJ7 = lbr.getExternalTorque().getSingleTorqueValue(JointEnum.J7);
		
		getLogger().info("Offsetwerte\nJ1 " + actTJ1 + "Nm\nJ2 " + actTJ2 + "Nm\nJ3 " + actTJ3 + "Nm\nJ4 " + actTJ4 + "Nm\nJ5 " + actTJ5 + "Nm\nJ6 " + actTJ6 + "Nm\nJ7 " + actTJ7 + "Nm");
		
		//Abbruchbedingungen pro Achse
		JointTorqueCondition jt1 = new JointTorqueCondition(JointEnum.J1, -threshold+actTJ1, threshold+actTJ1);
		JointTorqueCondition jt2 = new JointTorqueCondition(JointEnum.J2, -threshold+actTJ2, threshold+actTJ2);
		JointTorqueCondition jt3 = new JointTorqueCondition(JointEnum.J3, -threshold+actTJ3, threshold+actTJ3);
		JointTorqueCondition jt4 = new JointTorqueCondition(JointEnum.J4, -threshold+actTJ4, threshold+actTJ4);
		JointTorqueCondition jt5 = new JointTorqueCondition(JointEnum.J5, -threshold+actTJ5, threshold+actTJ5);
		JointTorqueCondition jt6 = new JointTorqueCondition(JointEnum.J6, -threshold+actTJ6, threshold+actTJ6);
		JointTorqueCondition jt7 = new JointTorqueCondition(JointEnum.J7, -threshold+actTJ7, threshold+actTJ7);

		ICondition forceCon = jt1.or(jt2, jt3, jt4, jt5, jt6, jt7);
		return forceCon;
	}
	
	private boolean behaviourAfterCollision() {
		boolean resumeMotion = true; 
		int sel = 0;
		IMotionContainer handle;
		
		CartesianImpedanceControlMode soft = new CartesianImpedanceControlMode();
			soft.parametrize(CartDOF.ALL).setDamping(.7);
			soft.parametrize(CartDOF.ROT).setStiffness(100);
			soft.parametrize(CartDOF.TRANSL).setStiffness(600);
				
		handle = lbr.moveAsync(positionHold(soft, -1, TimeUnit.SECONDS));
		sel = getApplicationUI().displayModalDialog(ApplicationDialogType.QUESTION,
			"Collision detected, Robot is in Impedance Control",
			"Continue Motion"
			);
		handle.cancel();
		if (sel != 0) {
			resumeMotion = false;
			lbr.move(ptp(getFrame("/start")).setJointVelocityRel(.3));
		}
				
		return resumeMotion;
	}	

}