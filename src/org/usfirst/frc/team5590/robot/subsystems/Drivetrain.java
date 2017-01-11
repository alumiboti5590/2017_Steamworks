package org.usfirst.frc.team5590.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *This is the subsystem to represent the Drivetrain
 */
public class Drivetrain extends Subsystem {
    
	// Port values 
	private static final int LEFTCONTROLLERPWM = 1;
    private static final int RIGHTCONTROLLERPWM = 0;
    
    // RobotDrive from FRC
    private RobotDrive robotDrive;
    
    
    public Drivetrain(){
    	robotDrive = new RobotDrive(LEFTCONTROLLERPWM,RIGHTCONTROLLERPWM);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

