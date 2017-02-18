package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RopeGrab extends Command {
	
	private double degrees;

    public RopeGrab(double degrees) {
    	this.degrees = degrees;
        requires(Robot.ropeGrabber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Starting RopeGrab");
    	Robot.ropeGrabber.resetEncoder();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.ropeGrabber.moveDistance(this.degrees);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.ropeGrabber.isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	// Set isFinished back
    	System.out.println("Ending RopeGrab");
    	Robot.ropeGrabber.isFinished = false;
    	// Reset the peripheral
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}