package org.usfirst.frc.team5590.robot;

import org.usfirst.frc.team5590.robot.commands.GearPusherCommand;
import org.usfirst.frc.team5590.robot.commands.RopeClimb;
import org.usfirst.frc.team5590.robot.commands.RopeGrab;
import org.usfirst.frc.team5590.robot.controllers.LogitechX3;
import org.usfirst.frc.team5590.robot.controllers.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
	// Ports for controllers
	private static final int XBOX_PORT = 0;
	private static final int LOGITECH_PORT = 1;
	
	// Controller objects
	public XboxController xbox;
	public LogitechX3 logitech;
	
	public OI() {
		xbox = new XboxController(XBOX_PORT);
		logitech = new LogitechX3(LOGITECH_PORT);
		
		logitech.button8.whenPressed(new GearPusherCommand());
		logitech.button7.whenPressed(new RopeGrab(90));
		logitech.button6.whenPressed(new RopeClimb(48.0));
	}
	

}

