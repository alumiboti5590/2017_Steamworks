package org.usfirst.frc.team5590.robot;

import org.usfirst.frc.team5590.robot.commands.GearHolderClose;
import org.usfirst.frc.team5590.robot.commands.GearHolderOpen;
import org.usfirst.frc.team5590.robot.commands.GearPullIn;
import org.usfirst.frc.team5590.robot.commands.GearPushOut;
import org.usfirst.frc.team5590.robot.commands.GearPusherCommand;
import org.usfirst.frc.team5590.robot.commands.RopeClimbCommand;
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
		
		// pusher test
		logitech.button12.whenPressed(new GearPushOut(0.25));
		logitech.button11.whenPressed(new GearPullIn(0.25));
		
		// holder manual controls in case gear needs to be loaded manually
		logitech.button10.whenPressed(new GearHolderOpen(0.25));
		logitech.button9.whenPressed(new GearHolderClose(0.25));
		
		//logitech.button10.whenPressed(new RopeGrab(-155));
		
		// Executes gear pusher command sequence when pressed
		logitech.button5.whenPressed(new GearPusherCommand());
		
		//logitech.button8.whenPressed(new RopeGrab(155));
		//logitech.button7.whenPressed(new RopeClimb(42.0));
		
		// Executes rope climb command sequence when pressed
		logitech.button6.whenPressed(new RopeClimbCommand());
		
	}
	

}

