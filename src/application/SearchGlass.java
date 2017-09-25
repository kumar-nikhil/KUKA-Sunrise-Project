package application;


import javax.inject.Inject;

import com.kuka.generated.ioAccess.Nikhil_ioIOGroup;
import com.kuka.roboticsAPI.applicationModel.RoboticsAPIApplication;
import static com.kuka.roboticsAPI.motionModel.BasicMotions.*;

import com.kuka.roboticsAPI.conditionModel.ICondition;
import com.kuka.roboticsAPI.conditionModel.JointTorqueCondition;
import com.kuka.roboticsAPI.controllerModel.Controller;
import com.kuka.roboticsAPI.deviceModel.JointEnum;
import com.kuka.roboticsAPI.deviceModel.LBR;
import com.kuka.roboticsAPI.geometricModel.Frame;
import com.kuka.roboticsAPI.motionModel.MotionBatch;
import com.kuka.roboticsAPI.motionModel.Spline;
import com.kuka.generated.ioAccess.Nikhil_ioIOGroup;


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
public class SearchGlass extends RoboticsAPIApplication {
	@Inject
	private LBR lbr;
	private Controller cab;
	Nikhil_ioIOGroup outputControl;

	@Override
	public void initialize() {
		// initialize your application here
		//cab = new Controller()
		cab = getController("KUKA_Sunrise_Cabinet_1");
		lbr = (LBR) getDevice(cab,
				"LBR_iiwa_14_R820_1");
		outputControl = new Nikhil_ioIOGroup(cab);

	}

	@Override
	public void run() {
		// your application execution starts here
		//lBR_iiwa_14_R820_1.move(ptpHome());
		// Search Bottle Routine
		searchRoutine();
	}
	
	public void searchRoutine(){
		lbr.move(ptp(getApplicationData().getFrame("/start")));
		ICondition hold = defineSensitivity(10);
		MotionBatch cart = new MotionBatch(
				ptp(getApplicationData().getFrame("/AppGlass1")),
				lin(getApplicationData().getFrame("/startSearch"))
				).breakWhen(hold);
		lbr.move(cart);
		ICondition found = defineSensitivity(1);
		//double yMax = 350.0;
		/*for(int i=0;i<yMax;i=i+10){
			double curPosY = lbr.getCurrentCartesianPosition(lbr.getFlange()).getY();
			Frame curPos = lbr.getCurrentCartesianPosition(lbr.getFlange());
			Frame newPos = curPos.setY(curPosY-i); 
			//lbr.move(lin(lbr.getCurrentCartesianPosition(lbr.getFlange().getY()+ curPosY)));
			//lbr.moveAsync(lin(newPos).setCartVelocity(10).breakWhen(found));
			Spline spl = new Spline(
					lin(newPos)
					);
			
			lbr.move(spl.breakWhen(found));
			
		}*/
		
		lbr.move(lin(getApplicationData().getFrame("/endSearch")).setCartVelocity(25).breakWhen(found));
		
		
		
		
		
		
	}
	
	private ICondition defineSensitivity(double thresh) {
		//double threshold = getApplicationData().getProcessData("threshold").getValue();
		double threshold = thresh;
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