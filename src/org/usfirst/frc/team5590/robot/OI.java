package org.usfirst.frc.team5590.robot;

import edu.wpi.first.wpilibj.buttons.Button;
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
	}
	
}

