/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3749.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_chooser.addDefault("Default Auto", kDefaultAuto);
		m_chooser.addObject("My Auto", kCustomAuto);
		SmartDashboard.putData("Auto choices", m_chooser);
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() 
	{
		m_autoSelected = m_chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() 
	{
		switch (m_autoSelected) {
			case kCustomAuto:
				// Put custom auto code here
				break;
			case kDefaultAuto:
			default:
				// Put default auto code here
				break;
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() 
	{
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() 
	{
	}
}

public class Arms()
{
	double y; //The y position of the arms in terms of a very large angle? in degrees?
	
	Arm(double yPos) // constructor
	{
		yPos = y;
	}
	
	public void moveToPos(double pos)
	{
		y = pos;
	}
	
		/**
		 * method armTime moves the robot's arm down or up for a certain amount of time
		 * @param down - if the arm should go down
		 * @param seconds - how long the arm moves for
		 */
		public void armTime (boolean down, double seconds)
		{
			// milliseconds when started
			double start = System.currentTimeMillis();
			
			// as long as the delta time from start to current time is less than seconds * 1000 (to milliseconds)
			while ((System.currentTimeMillis() - start) < seconds * 1000)
			{
				armMotor.set(ControlMode.PercentOutput, 0.2 * (down ? 1 : -1));
				Timer.delay(0.01);
			}
			armMotor.set(ControlMode.PercentOutput, -0.12);
		}
	
	public void moveDown(boolean down, double seconds)
	{
		// milliseconds when started
					double start = System.currentTimeMillis();
					
					// as long as the delta time from start to current time is less than seconds * 1000 (to milliseconds)
					while ((System.currentTimeMillis() - start) < seconds * 1000)
					{
						armMotor.set(ControlMode.PercentOutput, 0.2 * (down ? 1 : -1));
						Timer.delay(0.01);
					}
					armMotor.set(ControlMode.PercentOutput, -0.12);
	}
	Void setArmPos(double pos)
	{
		 
	}
	/**
	 * method reset - sets the encoder value to 0
	 */
	public void resetBottom()
	{
		armMotor.setSelectedSensorPosition(0, 0, 100);
	}
	Void setRange(min, max)
	
}