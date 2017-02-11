package org.usfirst.frc.team5590.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearPusher extends Subsystem {

	private static final int SOLENOID_IN = 0;
	private static final int SOLENOID_OUT = 1;

	DoubleSolenoid gearPusher;

	public GearPusher() {
		// Create a DoubleSolenoid
		gearPusher = new DoubleSolenoid(SOLENOID_IN, SOLENOID_OUT);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void pusherExtend() {
		gearPusher.set(DoubleSolenoid.Value.kForward);
	}

	public void pusherRetract() {
		gearPusher.set(DoubleSolenoid.Value.kReverse);
	}

	public void pusherOff() {
		gearPusher.set(DoubleSolenoid.Value.kOff);
	}

}