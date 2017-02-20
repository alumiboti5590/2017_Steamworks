package org.usfirst.frc.team5590.robot;

import org.usfirst.frc.team5590.robot.commands.GearHolderClose;
import org.usfirst.frc.team5590.robot.commands.GearHolderOpen;
import org.usfirst.frc.team5590.robot.commands.GearPullIn;
import org.usfirst.frc.team5590.robot.commands.GearPushOut;
import org.usfirst.frc.team5590.robot.commands.GearPusherCommand;
import org.usfirst.frc.team5590.robot.commands.RopeClimbCommand;
import org.usfirst.frc.team5590.robot.commands.SwitchCamera;
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
		
		// Switch the camera
		xbox.buttonX.whenPressed(new SwitchCamera());
		
		logitech.button5.whenPressed(new GearPusherCommand());
		
		
		logitech.button6.whenPressed(new RopeClimbCommand());
		
	}
	

}

