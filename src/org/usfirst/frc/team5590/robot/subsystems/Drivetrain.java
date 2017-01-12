package org.usfirst.frc.team5590.robot.subsystems;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *This is the subsystem to represent the Drivetrain
 */
public class Drivetrain extends Subsystem {
    
	// Port values 
	private static final int LEFTCONTROLLERPWM = 1;
    private static final int RIGHTCONTROLLERPWM = 0;
    private static final double MINSPEED = -1.0;
    private static final double MAXSPEED = 1.0;
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
    	double left = Robot.oi.xbox.getLeftStickY();
    	double right = Robot.oi.xbox.getRightStickY();
    	
    	double validLeft = this.ensureRange(left, MINSPEED, MAXSPEED);
    	double validRight = this.ensureRange(right, MINSPEED, MAXSPEED);
    	
    	robotDrive.tankDrive(validLeft, validRight);
    }
    
    
    /**
     * This method will set the speed of the motors
     * in the drivetrain to whatever *speed* is.
     */
    public void setSpeed(double speed) {
    	//This ensures that the speed received is valid
    	double validSpeed = this.ensureRange(speed, MINSPEED, MAXSPEED);
    	
    	robotDrive.arcadeDrive(validSpeed, 0);
    }
    
    
    public boolean setSpeedandDistance(double speed, double distance){
    	return true;
    }
    /**
     * This method will be called to STOP the robot.
     */
    public void stop() {
    	this.setSpeed(0);
    	
    }
    
    private  double ensureRange(double value, double min, double max) {
    	return Math.min(Math.max(value, min), max);
    	
    }
    
    
}

