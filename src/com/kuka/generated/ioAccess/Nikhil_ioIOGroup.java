package com.kuka.generated.ioAccess;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.kuka.roboticsAPI.controllerModel.Controller;
import com.kuka.roboticsAPI.ioModel.AbstractIOGroup;
import com.kuka.roboticsAPI.ioModel.IOTypes;

/**
 * Automatically generated class to abstract I/O access to I/O group <b>Nikhil_io</b>.<br>
 * <i>Please, do not modify!</i>
 * <p>
 * <b>I/O group description:</b><br>
 * MediaFlange
 */
@Singleton
public class Nikhil_ioIOGroup extends AbstractIOGroup
{
	/**
	 * Constructor to create an instance of class 'Nikhil_io'.<br>
	 * <i>This constructor is automatically generated. Please, do not modify!</i>
	 *
	 * @param controller
	 *            the controller, which has access to the I/O group 'Nikhil_io'
	 */
	@Inject
	public Nikhil_ioIOGroup(Controller controller)
	{
		super(controller, "Nikhil_io");

		addDigitalOutput("Gripper_open", IOTypes.BOOLEAN, 1);
		addInput("Gripper_close", IOTypes.BOOLEAN, 1);
	}

	/**
	 * Gets the value of the <b>digital output '<i>Gripper_open</i>'</b>.<br>
	 * <i>This method is automatically generated. Please, do not modify!</i>
	 * <p>
	 * <b>I/O direction and type:</b><br>
	 * digital output
	 * <p>
	 * <b>User description of the I/O:</b><br>
	 * ./.
	 * <p>
	 * <b>Range of the I/O value:</b><br>
	 * [false; true]
	 *
	 * @return current value of the digital output 'Gripper_open'
	 */
	public boolean getGripper_open()
	{
		return getBooleanIOValue("Gripper_open", true);
	}

	/**
	 * Sets the value of the <b>digital output '<i>Gripper_open</i>'</b>.<br>
	 * <i>This method is automatically generated. Please, do not modify!</i>
	 * <p>
	 * <b>I/O direction and type:</b><br>
	 * digital output
	 * <p>
	 * <b>User description of the I/O:</b><br>
	 * ./.
	 * <p>
	 * <b>Range of the I/O value:</b><br>
	 * [false; true]
	 *
	 * @param value
	 *            the value, which has to be written to the digital output 'Gripper_open'
	 */
	public void setGripper_open(java.lang.Boolean value)
	{
		setDigitalOutput("Gripper_open", value);
	}

	/**
	 * Gets the value of the <b>digital input '<i>Gripper_close</i>'</b>.<br>
	 * <i>This method is automatically generated. Please, do not modify!</i>
	 * <p>
	 * <b>I/O direction and type:</b><br>
	 * digital input
	 * <p>
	 * <b>User description of the I/O:</b><br>
	 * ./.
	 * <p>
	 * <b>Range of the I/O value:</b><br>
	 * [false; true]
	 *
	 * @return current value of the digital input 'Gripper_close'
	 */
	public boolean getGripper_close()
	{
		return getBooleanIOValue("Gripper_close", false);
	}

}
