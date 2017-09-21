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
import com.kuka.roboticsAPI.geometricModel.CartPlane;
import com.kuka.roboticsAPI.motionModel.IMotionContainer;
import com.kuka.roboticsAPI.motionModel.controlModeModel.CartesianSineImpedanceControlMode;
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
public class WiggleBounce extends RoboticsAPIApplication {
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
		//lbr.move(ptpHome());
		wiggleBounce();
	}
	
	private void wiggleBounce() {
		getLogger().info("Wiggle & Bounce");
		
		int sel = 0;
		String actSwing = "";
		
		//Abbruchbedingung für eine Kollision in grauer Technik
		ICondition forceCon = defineSensitivity();

		//Definition der einzelnen Modi
		// Sinus mit Frequenz 2 Hz, Amplitude 50 N, Steifigkeit 1500 [N/m]
		CartesianSineImpedanceControlMode shakeSinX;
		shakeSinX = CartesianSineImpedanceControlMode.createSinePattern(CartDOF.X, 2, 50, 1500);
		shakeSinX.parametrize(CartDOF.ALL).setDamping(0.7);
		
		// Sinus mit Frequenz 5 Hz, Amplitude 5 Nm, Steifigkeit 15 [Nm/rad]
		CartesianSineImpedanceControlMode shakeSinA;
		shakeSinA = CartesianSineImpedanceControlMode.createSinePattern(CartDOF.A, 5, 5, 15);
		shakeSinA.parametrize(CartDOF.ALL).setDamping(0.7);
		
		// Lissajous-Schwingung mit Frequenz 1 Hz, Amplitude 50 N, Steifigkeit 1500 [N/m]
		CartesianSineImpedanceControlMode shakeLis;
		shakeLis = CartesianSineImpedanceControlMode.createLissajousPattern(CartPlane.XY, 1, 50, 1500);
		shakeLis.parametrize(CartDOF.Z).setStiffness(1000); 		// ... mit Steifigkeit 1000 [N/m] in Z-Richtung
		shakeLis.setRiseTime(3);									// ... ueber 3 Sekunden ansteigend
		
		// Spiral-Schwingung mit Frequenz 15 Hz, Amplitude 16 N, Steifigkeit 1000 [N/m]
		CartesianSineImpedanceControlMode shakeSpirale;
		shakeSpirale = CartesianSineImpedanceControlMode.createSpiralPattern(CartPlane.XY, 15, 16, 1000, 180);
		shakeSpirale.setRiseTime(0.2).setHoldTime(60).setFallTime(0.5);
		
		
		//Bewegungsprogrammierung
		IMotionContainer handle;
		handle = lbr.move(ptp(getFrame("/start")).setJointVelocityRel(0.3));
		
		while (sel != 4) {
			switch (sel){
				case 0:
					actSwing = "Sine wave in X direction with 2 Hz";
					handle = lbr.moveAsync(positionHold(shakeSinX, -1, TimeUnit.SECONDS).breakWhen(forceCon));
					break;
				case 1:
					actSwing = "Vibration around tool Z with 5 Hz";
					handle = lbr.moveAsync(positionHold(shakeSinA, -1, TimeUnit.SECONDS).breakWhen(forceCon));
					break;
				case 2:
					actSwing = "Lissajous figure in XY plane";
					handle = lbr.moveAsync(positionHold(shakeLis, -1, TimeUnit.SECONDS).breakWhen(forceCon));
					break;
				case 3:
					actSwing = "Spiral in XY plane";
					handle = lbr.moveAsync(positionHold(shakeSpirale, -1, TimeUnit.SECONDS).breakWhen(forceCon));
					break;
				default:
					break;				
			}
			sel = getApplicationUI().displayModalDialog(ApplicationDialogType.QUESTION,
					"Selection of the next vibration \n\nCurrent:" + actSwing, "Sinus X 2 Hz", "Sinus A 3 Hz", "Lissajous XY 1 Hz", "Spiral XY 15 Hz", "END");	
			handle.cancel();
			lbr.move(ptp(getFrame("/start")).setJointVelocityRel(0.3));
		}

		lbr.move(ptp(getFrame("/start")).setJointVelocityRel(0.3));
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

	
}