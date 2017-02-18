package org.usfirst.frc.team5590.robot.subsystems;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RopeGrabber extends Subsystem {
	// Peripherals needed
	static Encoder grabEnc;
	static SpeedController grabSpeed;

	// creates two variables that tell the signals and are equal to the ports
	// they are in
	private static final int ROTATIONAL_ENCODER_SIGNAL_INPUT = 2;
	private static final int ROTATIONAL_ENCODER_SIGNAL_OUTPUT = 3;
	
	// creates a variable for the speed controller PWM
	private static final int ROPE_GRAB_PWM = 3;

	// Every 45.1818 = 1 inch
	private static final double DISTANCE_PER_PULSE = .02213280569; // inches

	// 497 counts / 1 revolution (360 degrees)
	private static final double DEGREES_PER_PULSE = 0.789;
	
	private static final double GRABBER_SPEED = .2;

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

		boolean neg = degrees < 0 ? true : false;

		if (neg) {

			// Set the motor if in the allowed distance
			if (getDegrees() < degrees) {
				grabSpeed.stopMotor();
				isFinished = true;
				return;
			}
			
			double validSpeed = ensureRange(-GRABBER_SPEED, -1, 1);
			grabSpeed.set(validSpeed);
			
		} else {
			// Stop the motor if in the allowed distance
			if (getDegrees() > degrees) {
				grabSpeed.stopMotor();
				isFinished = true;
				return;
			}

			double validSpeed;

			validSpeed = ensureRange(GRABBER_SPEED, -1, 1);
			grabSpeed.set(validSpeed);
		}

		System.out.println("Raw degrees " + getDegrees());

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

	private double ensureRange(double value, double min, double max) {
		return Math.min(Math.max(value, min), max);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}