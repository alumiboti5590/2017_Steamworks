package org.usfirst.frc.team5590.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearPusherCommand extends CommandGroup {
    private static final double PUSHERSECONDS = 1.0;
    private static final double HOLDERSECONDS = 1.0;
    
    
    public  GearPusherCommand() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	
    	addSequential(new GearHolderOpen(HOLDERSECONDS));
    	addSequential(new GearPushOut(PUSHERSECONDS));
    	addSequential(new GearPullIn(PUSHERSECONDS));
    	addSequential(new GearHolderClose(HOLDERSECONDS));
    }
}