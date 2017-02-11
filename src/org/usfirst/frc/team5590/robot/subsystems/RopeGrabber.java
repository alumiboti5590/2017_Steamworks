package org.usfirst.frc.team5590.robot.subsystems;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RopeGrabber extends Subsystem {
	static Encoder grabEnc;
	static SpeedController grabSpeed;

	// creates two variables that tell the signals and are equal to the ports
	// they are in
	private static final int ROTATIONAL_ENCODER_SIGNAL_INPUT = 2;
	private static final int ROTATIONAL_ENCODER_SIGNAL_OUTPUT = 3;

	// Every 45.1818 = 1 inch
	private static final double DISTANCE_PER_PULSE = .02213280569; // inches

	// 497 counts / 1 revolution (360 degrees)
	private static final double DEGREES_PER_PULSE = 1.3805555556;

	// creates a variable for the speed controller PWM
	private static final int ROPE_GRAB_PWM = 3;

	// Error allowed
	private static final double ERROR_ALLOWED = .3;
	
	private static final double SPEED_MULTIPLYER = 1.0;

	// Non-static variables
	public static boolean isFinished = false;

	// constructs the speed controller and the encoder
	public RopeGrabber() {

		// Set up encoder
		grabEnc = new Encoder(ROTATIONAL_ENCODER_SIGNAL_INPUT, ROTATIONAL_ENCODER_SIGNAL_OUTPUT, false,
				EncodingType.k4X);
		grabEnc.setDistancePerPulse(DISTANCE_PER_PULSE);

		grabSpeed = new TalonSRX(ROPE_GRAB_PWM);
	}

	public void moveDistance(double degrees) {
		
		// Stop the motor if in the allowed distance
		if (Math.abs(getDegrees() - degrees) < ERROR_ALLOWED) {
			grabSpeed.stopMotor();
			isFinished = true;
		}
		
		double validSpeed;

		switch (getMotorProgress(degrees)) {

		// Fast motor
		case 0:
			// Code here
			validSpeed = ensureRange(1 * SPEED_MULTIPLYER, -1, 1);
			grabSpeed.set(validSpeed);
			break;

		// Medium motor
		case 1:
			// Code here
			validSpeed = ensureRange(.5 * SPEED_MULTIPLYER, -1, 1);
			grabSpeed.set(validSpeed);
			break;

		// Slow motor
		case 2:
			// Code here
			validSpeed = ensureRange(.2 * SPEED_MULTIPLYER, -1, 1);
			grabSpeed.set(validSpeed);
			break;

		// Fix case
		case 3:
			// Code here
			grabSpeed.set(-.1);
			break;

		}
	}

	public void resetGrabEnc() {

	}

	public int getEncoder() {
		return grabEnc.get();
	}

	public void resetEncoder() {
		grabEnc.reset();
	}

	public double getDegrees() {
		return DEGREES_PER_PULSE * grabEnc.get();
	}

	private int getMotorProgress(double degreesToMove) {
		
		double degrees = getDegrees();
		
		// If overshot
		if (degreesToMove < degrees) {
			return 3;
		}
		
		// What we are doing below
		//
		//   0            .6   .83     d
		//   |-------------|-----|-----|
		
		// Figure out how fast to go
		if ((.83333 * degreesToMove) < degrees) {
			// Slow motor
			return 2;
		} else if ((.66666 * degreesToMove) < degrees) {
			// Medium Speed
			return 1;
		} else {
			// Fast speed
			return 0;
		}
	}

	private double ensureRange(double value, double min, double max) {
		return Math.min(Math.max(value, min), max);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}