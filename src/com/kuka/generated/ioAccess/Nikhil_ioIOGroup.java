package com.kuka.generated.ioAccess;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.kuka.roboticsAPI.controllerModel.Controller;
import com.kuka.roboticsAPI.ioModel.AbstractIOGroup;
import com.kuka.roboticsAPI.ioModel.IOTypes;
import com.kuka.common.ThreadUtil;
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
		addDigitalOutput("Gripper_close", IOTypes.BOOLEAN, 1);
		addDigitalOutput("OUT1", IOTypes.BOOLEAN, 1);
		addDigitalOutput("OUT2", IOTypes.BOOLEAN, 1);
		addInput("Input1", IOTypes.BOOLEAN, 1);
		addInput("Input2", IOTypes.BOOLEAN, 1);
		addInput("Input3", IOTypes.BOOLEAN, 1);
		addInput("Input4", IOTypes.BOOLEAN, 1);
		addInput("Input5", IOTypes.BOOLEAN, 1);
		addInput("Input6", IOTypes.BOOLEAN, 1);
		addInput("Input7", IOTypes.BOOLEAN, 1);
		addInput("Input8", IOTypes.BOOLEAN, 1);
		addDigitalOutput("OUT3", IOTypes.BOOLEAN, 1);
		addDigitalOutput("OUT4", IOTypes.BOOLEAN, 1);
		addDigitalOutput("OUT5", IOTypes.BOOLEAN, 1);
		addDigitalOutput("OUT6", IOTypes.BOOLEAN, 1);
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
	 * Gets the value of the <b>digital output '<i>Gripper_close</i>'</b>.<br>
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
	 * @return current value of the digital output 'Gripper_close'
	 */
	public boolean getGripper_close()
	{
		return getBooleanIOValue("Gripper_close", true);
	}

	/**
	 * Sets the value of the <b>digital output '<i>Gripper_close</i>'</b>.<br>
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
	 *            the value, which has to be written to the digital output 'Gripper_close'
	 */
	public void setGripper_close(java.lang.Boolean value)
	{
		setDigitalOutput("Gripper_close", value);
	}

	/**
	 * Gets the value of the <b>digital output '<i>OUT1</i>'</b>.<br>
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
	 * @return current value of the digital output 'OUT1'
	 */
	public boolean getOUT1()
	{
		return getBooleanIOValue("OUT1", true);
	}

	/**
	 * Sets the value of the <b>digital output '<i>OUT1</i>'</b>.<br>
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
	 *            the value, which has to be written to the digital output 'OUT1'
	 */
	public void setOUT1(java.lang.Boolean value)
	{
		setDigitalOutput("OUT1", value);
	}

	/**
	 * Gets the value of the <b>digital output '<i>OUT2</i>'</b>.<br>
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
	 * @return current value of the digital output 'OUT2'
	 */
	public boolean getOUT2()
	{
		return getBooleanIOValue("OUT2", true);
	}

	/**
	 * Sets the value of the <b>digital output '<i>OUT2</i>'</b>.<br>
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
	 *            the value, which has to be written to the digital output 'OUT2'
	 */
	public void setOUT2(java.lang.Boolean value)
	{
		setDigitalOutput("OUT2", value);
	}

	/**
	 * Gets the value of the <b>digital input '<i>Input1</i>'</b>.<br>
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
	 * @return current value of the digital input 'Input1'
	 */
	public boolean getInput1()
	{
		return getBooleanIOValue("Input1", false);
	}

	/**
	 * Gets the value of the <b>digital input '<i>Input2</i>'</b>.<br>
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
	 * @return current value of the digital input 'Input2'
	 */
	public boolean getInput2()
	{
		return getBooleanIOValue("Input2", false);
	}

	/**
	 * Gets the value of the <b>digital input '<i>Input3</i>'</b>.<br>
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
	 * @return current value of the digital input 'Input3'
	 */
	public boolean getInput3()
	{
		return getBooleanIOValue("Input3", false);
	}

	/**
	 * Gets the value of the <b>digital input '<i>Input4</i>'</b>.<br>
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
	 * @return current value of the digital input 'Input4'
	 */
	public boolean getInput4()
	{
		return getBooleanIOValue("Input4", false);
	}

	/**
	 * Gets the value of the <b>digital input '<i>Input5</i>'</b>.<br>
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
	 * @return current value of the digital input 'Input5'
	 */
	public boolean getInput5()
	{
		return getBooleanIOValue("Input5", false);
	}

	/**
	 * Gets the value of the <b>digital input '<i>Input6</i>'</b>.<br>
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
	 * @return current value of the digital input 'Input6'
	 */
	public boolean getInput6()
	{
		return getBooleanIOValue("Input6", false);
	}

	/**
	 * Gets the value of the <b>digital input '<i>Input7</i>'</b>.<br>
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
	 * @return current value of the digital input 'Input7'
	 */
	public boolean getInput7()
	{
		return getBooleanIOValue("Input7", false);
	}

	/**
	 * Gets the value of the <b>digital input '<i>Input8</i>'</b>.<br>
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
	 * @return current value of the digital input 'Input8'
	 */
	public boolean getInput8()
	{
		return getBooleanIOValue("Input8", false);
	}

	/**
	 * Gets the value of the <b>digital output '<i>OUT3</i>'</b>.<br>
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
	 * @return current value of the digital output 'OUT3'
	 */
	public boolean getOUT3()
	{
		return getBooleanIOValue("OUT3", true);
	}

	/**
	 * Sets the value of the <b>digital output '<i>OUT3</i>'</b>.<br>
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
	 *            the value, which has to be written to the digital output 'OUT3'
	 */
	public void setOUT3(java.lang.Boolean value)
	{
		setDigitalOutput("OUT3", value);
	}

	/**
	 * Gets the value of the <b>digital output '<i>OUT4</i>'</b>.<br>
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
	 * @return current value of the digital output 'OUT4'
	 */
	public boolean getOUT4()
	{
		return getBooleanIOValue("OUT4", true);
	}

	/**
	 * Sets the value of the <b>digital output '<i>OUT4</i>'</b>.<br>
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
	 *            the value, which has to be written to the digital output 'OUT4'
	 */
	public void setOUT4(java.lang.Boolean value)
	{
		setDigitalOutput("OUT4", value);
	}

	/**
	 * Gets the value of the <b>digital output '<i>OUT5</i>'</b>.<br>
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
	 * @return current value of the digital output 'OUT5'
	 */
	public boolean getOUT5()
	{
		return getBooleanIOValue("OUT5", true);
	}

	/**
	 * Sets the value of the <b>digital output '<i>OUT5</i>'</b>.<br>
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
	 *            the value, which has to be written to the digital output 'OUT5'
	 */
	public void setOUT5(java.lang.Boolean value)
	{
		setDigitalOutput("OUT5", value);
	}

	/**
	 * Gets the value of the <b>digital output '<i>OUT6</i>'</b>.<br>
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
	 * @return current value of the digital output 'OUT6'
	 */
	public boolean getOUT6()
	{
		return getBooleanIOValue("OUT6", true);
	}

	/**
	 * Sets the value of the <b>digital output '<i>OUT6</i>'</b>.<br>
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
	 *            the value, which has to be written to the digital output 'OUT6'
	 */
	public void setOUT6(java.lang.Boolean value)
	{
		setDigitalOutput("OUT6", value);
	}
	
	public void pulse(String output , java.lang.Boolean value, long time)
	{
		setDigitalOutput(output, true);
		ThreadUtil.milliSleep(time);
		setDigitalOutput(output, false);
		ThreadUtil.milliSleep(time);
	}

}
