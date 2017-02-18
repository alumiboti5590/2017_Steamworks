package org.usfirst.frc.team5590.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RopeClimbCommand extends CommandGroup {
	private static final double GRABBER_DEGREES = 155.0;
	
    public RopeClimbCommand() {
    	 // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	addSequential(new RopeGrab(GRABBER_DEGREES));
    	addSequential(new RopeClimb(11.0));
    	addSequential(new RopeGrab(-GRABBER_DEGREES));
    	addSequential(new RopeClimb(34.0));
    }
}
