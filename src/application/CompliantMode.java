package application;


import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import com.kuka.roboticsAPI.applicationModel.RoboticsAPIApplication;
import static com.kuka.roboticsAPI.motionModel.BasicMotions.*;

import com.kuka.roboticsAPI.controllerModel.Controller;
import com.kuka.roboticsAPI.deviceModel.LBR;
import com.kuka.roboticsAPI.geometricModel.CartDOF;
import com.kuka.roboticsAPI.motionModel.IMotionContainer;
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
public class CompliantMode extends RoboticsAPIApplication {
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
		stiffness();
	}
	
	private void stiffness() {
		getLogger().info("Stiffness");
		
		int answer = 0;
		double stiffX = 1000.0;
		double stiffY = 300.0;
		double stiffZ = 600.0;

		double highStiff = /*getApplicationData().getProcessData("highStiff").getValue()*/ 2500;
		double midStiff = /*getApplicationData().getProcessData("midStiff").getValue()*/ 1000;
		double lowStiff = /*getApplicationData().getProcessData("lowStiff").getValue()*/500;

		
		lbr.move(ptp(getFrame("/start")).setJointVelocityRel(0.3));
		CartesianImpedanceControlMode modeHandfuehren = new CartesianImpedanceControlMode();
		do {
			switch (answer) {
			case 0:
				stiffX = 1000.0;
				stiffY = 300.0;
				stiffZ = 600.0;
				break;
			case 1:
				stiffX = lowStiff;
				stiffY = lowStiff;
				stiffZ = lowStiff;
				break;
			case 2:
				stiffX = midStiff;
				stiffY = midStiff;
				stiffZ = midStiff;
				break;
			case 3:
				stiffX = highStiff;
				stiffY = highStiff;
				stiffZ = highStiff;
				break;
			}
			modeHandfuehren.parametrize(CartDOF.X).setStiffness(stiffX);
			modeHandfuehren.parametrize(CartDOF.Y).setStiffness(stiffY);
			modeHandfuehren.parametrize(CartDOF.Z).setStiffness(stiffZ);
			modeHandfuehren.parametrize(CartDOF.ROT).setStiffness(100.0);

			IMotionContainer handle;
				handle = lbr.moveAsync(positionHold(modeHandfuehren, -1, TimeUnit.SECONDS));

				answer = getApplicationUI().displayModalDialog(
						ApplicationDialogType.INFORMATION,
						"rigidity in X: " + stiffX
								+ " N/m\nrigidity in Y: " + stiffY
								+ " N/m\nrigidity in Z: " + stiffZ + " N/m",
						"To start position and end", "Soft", "Medium", "Hard");
				handle.cancel();
				lbr.move(ptp(getFrame("/start")).setJointVelocityRel(0.3));
		} while (answer != 0);
	}	
}