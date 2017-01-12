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
    	robotDrive = new RobotDrive(LEFTCONTROLLERPWM, RIGHTCONTROLLERPWM);
    }

    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    /**
     * This method will set the speed of the drivetrain 
     * motors according to the joystick controllers.
     */
    public void joystickSpeed() {
    	
    }
    
    
    /**
     * This method will set the speed of the motors
     * in the drivetrain to whatever *speed* is.
     */
    public void setSpeed(double speed) {
    	
    }
    
    
    
    /**
     * This method will be called to STOP the robot.
     */
    public void stop() {
    	
    }
    
    
}

