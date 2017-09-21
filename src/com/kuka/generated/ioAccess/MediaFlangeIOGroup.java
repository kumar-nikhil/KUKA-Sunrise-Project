package com.kuka.generated.ioAccess;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.kuka.roboticsAPI.controllerModel.Controller;
import com.kuka.roboticsAPI.ioModel.AbstractIOGroup;
import com.kuka.roboticsAPI.ioModel.IOTypes;

/**
 * Automatically generated class to abstract I/O access to I/O group <b>MediaFlange</b>.<br>
 * <i>Please, do not modify!</i>
 * <p>
 * <b>I/O group description:</b><br>
 * This I/O Group contains the In-/Outputs for the Media-Flange IO.
 */
@Singleton
public class MediaFlangeIOGroup extends AbstractIOGroup
{
	/**
	 * Constructor to create an instance of class 'MediaFlange'.<br>
	 * <i>This constructor is automatically generated. Please, do not modify!</i>
	 *
	 * @param controller
	 *            the controller, which has access to the I/O group 'MediaFlange'
	 */
	@Inject
	public MediaFlangeIOGroup(Controller controller)
	{
		super(controller, "MediaFlange");

		addMockedInput("Input1", IOTypes.BOOLEAN, 1, false);
		addMockedInput("Input2", IOTypes.BOOLEAN, 1, false);
		addMockedInput("Input3", IOTypes.BOOLEAN, 1, false);
		addMockedInput("Input4", IOTypes.BOOLEAN, 1, false);
		addMockedInput("Input5", IOTypes.BOOLEAN, 1, false);
		addMockedInput("Input6", IOTypes.BOOLEAN, 1, false);
		addMockedInput("Input7", IOTypes.BOOLEAN, 1, false);
		addMockedInput("Input8", IOTypes.BOOLEAN, 1, false);
		addMockedDigitalOutput("Output1", IOTypes.BOOLEAN, 1);
		addMockedDigitalOutput("Output2", IOTypes.BOOLEAN, 1);
		addMockedDigitalOutput("Output3", IOTypes.BOOLEAN, 1);
		addMockedDigitalOutput("Output4", IOTypes.BOOLEAN, 1);
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
	* 
	 * @deprecated The output 'Input1' has not been assigned to a field bus address - thus this operation will be <b>simulated</b> only.
	 */
	@Deprecated
	public boolean getInput1()
	{
		return getBooleanIOValue("Input1", false);
	}

	/**
	 * Sets the value of the <b>mocked digital input '<i>Input1</i>'</b>.<br>
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
	 * @param value
	 *            the value, which has to be written to the mocked digital input 'Input1'
	* 
	 * @deprecated The output 'Input1' has not been assigned to a field bus address - thus this operation will be <b>simulated</b> only.
	 */
	@Deprecated
	public void setMockedInput1Value(java.lang.Boolean value)
	{
		setMockedInput("Input1", value);
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
	* 
	 * @deprecated The output 'Input2' has not been assigned to a field bus address - thus this operation will be <b>simulated</b> only.
	 */
	@Deprecated
	public boolean getInput2()
	{
		return getBooleanIOValue("Input2", false);
	}

	/**
	 * Sets the value of the <b>mocked digital input '<i>Input2</i>'</b>.<br>
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
	 * @param value
	 *            the value, which has to be written to the mocked digital input 'Input2'
	* 
	 * @deprecated The output 'Input2' has not been assigned to a field bus address - thus this operation will be <b>simulated</b> only.
	 */
	@Deprecated
	public void setMockedInput2Value(java.lang.Boolean value)
	{
		setMockedInput("Input2", value);
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
	* 
	 * @deprecated The output 'Input3' has not been assigned to a field bus address - thus this operation will be <b>simulated</b> only.
	 */
	@Deprecated
	public boolean getInput3()
	{
		return getBooleanIOValue("Input3", false);
	}

	/**
	 * Sets the value of the <b>mocked digital input '<i>Input3</i>'</b>.<br>
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
	 * @param value
	 *            the value, which has to be written to the mocked digital input 'Input3'
	* 
	 * @deprecated The output 'Input3' has not been assigned to a field bus address - thus this operation will be <b>simulated</b> only.
	 */
	@Deprecated
	public void setMockedInput3Value(java.lang.Boolean value)
	{
		setMockedInput("Input3", value);
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
	* 
	 * @deprecated The output 'Input4' has not been assigned to a field bus address - thus this operation will be <b>simulated</b> only.
	 */
	@Deprecated
	public boolean getInput4()
	{
		return getBooleanIOValue("Input4", false);
	}

	/**
	 * Sets the value of the <b>mocked digital input '<i>Input4</i>'</b>.<br>
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
	 * @param value
	 *            the value, which has to be written to the mocked digital input 'Input4'
	* 
	 * @deprecated The output 'Input4' has not been assigned to a field bus address - thus this operation will be <b>simulated</b> only.
	 */
	@Deprecated
	public void setMockedInput4Value(java.lang.Boolean value)
	{
		setMockedInput("Input4", value);
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
	* 
	 * @deprecated The output 'Input5' has not been assigned to a field bus address - thus this operation will be <b>simulated</b> only.
	 */
	@Deprecated
	public boolean getInput5()
	{
		return getBooleanIOValue("Input5", false);
	}

	/**
	 * Sets the value of the <b>mocked digital input '<i>Input5</i>'</b>.<br>
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
	 * @param value
	 *            the value, which has to be written to the mocked digital input 'Input5'
	* 
	 * @deprecated The output 'Input5' has not been assigned to a field bus address - thus this operation will be <b>simulated</b> only.
	 */
	@Deprecated
	public void setMockedInput5Value(java.lang.Boolean value)
	{
		setMockedInput("Input5", value);
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
	* 
	 * @deprecated The output 'Input6' has not been assigned to a field bus address - thus this operation will be <b>simulated</b> only.
	 */
	@Deprecated
	public boolean getInput6()
	{
		return getBooleanIOValue("Input6", false);
	}

	/**
	 * Sets the value of the <b>mocked digital input '<i>Input6</i>'</b>.<br>
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
	 * @param value
	 *            the value, which has to be written to the mocked digital input 'Input6'
	* 
	 * @deprecated The output 'Input6' has not been assigned to a field bus address - thus this operation will be <b>simulated</b> only.
	 */
	@Deprecated
	public void setMockedInput6Value(java.lang.Boolean value)
	{
		setMockedInput("Input6", value);
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
	* 
	 * @deprecated The output 'Input7' has not been assigned to a field bus address - thus this operation will be <b>simulated</b> only.
	 */
	@Deprecated
	public boolean getInput7()
	{
		return getBooleanIOValue("Input7", false);
	}

	/**
	 * Sets the value of the <b>mocked digital input '<i>Input7</i>'</b>.<br>
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
	 * @param value
	 *            the value, which has to be written to the mocked digital input 'Input7'
	* 
	 * @deprecated The output 'Input7' has not been assigned to a field bus address - thus this operation will be <b>simulated</b> only.
	 */
	@Deprecated
	public void setMockedInput7Value(java.lang.Boolean value)
	{
		setMockedInput("Input7", value);
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
	* 
	 * @deprecated The output 'Input8' has not been assigned to a field bus address - thus this operation will be <b>simulated</b> only.
	 */
	@Deprecated
	public boolean getInput8()
	{
		return getBooleanIOValue("Input8", false);
	}

	/**
	 * Sets the value of the <b>mocked digital input '<i>Input8</i>'</b>.<br>
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
	 * @param value
	 *            the value, which has to be written to the mocked digital input 'Input8'
	* 
	 * @deprecated The output 'Input8' has not been assigned to a field bus address - thus this operation will be <b>simulated</b> only.
	 */
	@Deprecated
	public void setMockedInput8Value(java.lang.Boolean value)
	{
		setMockedInput("Input8", value);
	}

	/**
	 * Gets the value of the <b>digital output '<i>Output1</i>'</b>.<br>
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
	 * @return current value of the digital output 'Output1'
	* 
	 * @deprecated The output 'Output1' has not been assigned to a field bus address - thus this operation will be <b>simulated</b> only.
	 */
	@Deprecated
	public boolean getOutput1()
	{
		return getBooleanIOValue("Output1", true);
	}

	/**
	 * Sets the value of the <b>digital output '<i>Output1</i>'</b>.<br>
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
	 *            the value, which has to be written to the digital output 'Output1'
	* 
	 * @deprecated The output 'Output1' has not been assigned to a field bus address - thus this operation will be <b>simulated</b> only.
	 */
	@Deprecated
	public void setOutput1(java.lang.Boolean value)
	{
		setDigitalOutput("Output1", value);
	}

	/**
	 * Gets the value of the <b>digital output '<i>Output2</i>'</b>.<br>
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
	 * @return current value of the digital output 'Output2'
	* 
	 * @deprecated The output 'Output2' has not been assigned to a field bus address - thus this operation will be <b>simulated</b> only.
	 */
	@Deprecated
	public boolean getOutput2()
	{
		return getBooleanIOValue("Output2", true);
	}

	/**
	 * Sets the value of the <b>digital output '<i>Output2</i>'</b>.<br>
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
	 *            the value, which has to be written to the digital output 'Output2'
	* 
	 * @deprecated The output 'Output2' has not been assigned to a field bus address - thus this operation will be <b>simulated</b> only.
	 */
	@Deprecated
	public void setOutput2(java.lang.Boolean value)
	{
		setDigitalOutput("Output2", value);
	}

	/**
	 * Gets the value of the <b>digital output '<i>Output3</i>'</b>.<br>
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
	 * @return current value of the digital output 'Output3'
	* 
	 * @deprecated The output 'Output3' has not been assigned to a field bus address - thus this operation will be <b>simulated</b> only.
	 */
	@Deprecated
	public boolean getOutput3()
	{
		return getBooleanIOValue("Output3", true);
	}

	/**
	 * Sets the value of the <b>digital output '<i>Output3</i>'</b>.<br>
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
	 *            the value, which has to be written to the digital output 'Output3'
	* 
	 * @deprecated The output 'Output3' has not been assigned to a field bus address - thus this operation will be <b>simulated</b> only.
	 */
	@Deprecated
	public void setOutput3(java.lang.Boolean value)
	{
		setDigitalOutput("Output3", value);
	}

	/**
	 * Gets the value of the <b>digital output '<i>Output4</i>'</b>.<br>
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
	 * @return current value of the digital output 'Output4'
	* 
	 * @deprecated The output 'Output4' has not been assigned to a field bus address - thus this operation will be <b>simulated</b> only.
	 */
	@Deprecated
	public boolean getOutput4()
	{
		return getBooleanIOValue("Output4", true);
	}

	/**
	 * Sets the value of the <b>digital output '<i>Output4</i>'</b>.<br>
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
	 *            the value, which has to be written to the digital output 'Output4'
	* 
	 * @deprecated The output 'Output4' has not been assigned to a field bus address - thus this operation will be <b>simulated</b> only.
	 */
	@Deprecated
	public void setOutput4(java.lang.Boolean value)
	{
		setDigitalOutput("Output4", value);
	}

}
