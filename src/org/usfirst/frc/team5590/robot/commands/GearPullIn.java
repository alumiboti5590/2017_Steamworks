package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearPullIn extends Command {

    public GearPullIn(double seconds) {
    	// What subsystem is required by the command.
    	requires(Robot.gearPusher);
    	
    	// How long to run the command for.
    	setTimeout(seconds);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Code to check continuously
    	Robot.gearPusher.pusherRetract();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// If the command finished or not
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	// Once the command is done, stop the solenoid.
    	Robot.gearPusher.pusherOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	// If another command needs gearPusher, just stop the action.
    	Robot.gearPusher.pusherOff();
    }
}