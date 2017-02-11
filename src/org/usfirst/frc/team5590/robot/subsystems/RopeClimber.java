package org.usfirst.frc.team5590.robot.subsystems;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RopeClimber extends Subsystem {
	static Encoder climbEnc;
	static SpeedController ropeSpeed;

	// creates two variables that tell the signals and are equal to the ports
	// they are in
	private static final int ROTATIONAL_ENCODER_SIGNAL_INPUT = 0;
	private static final int ROTATIONAL_ENCODER_SIGNAL_OUTPUT = 1;

	// creates a variable for the speed controller PWM
	private static final int ROPE_CLIMB_PWM = 2;

	// How many inches per pulse the encoder measures
	private static final double DISTANCE_PER_PULSE = .02213280569;

	// How many degrees per pulse the encoder measures
	private static final double DEGREES_PER_PULSE = 1.380555556;

	// Amount allowed to account for over or under shooting
	private static final double ERROR_ALLOWED = 0.5;
	
	private static final double SPEED_MULTIPLIER = 1.0;

	private int speed;
	
	public static boolean isFinished = false;

	// constructs the speed controller and the encoder
	public RopeClimber() {
		climbEnc = new Encoder(ROTATIONAL_ENCODER_SIGNAL_INPUT, ROTATIONAL_ENCODER_SIGNAL_OUTPUT, false,
				EncodingType.k2X);
		climbEnc.setDistancePerPulse(DISTANCE_PER_PULSE);
		ropeSpeed = new TalonSRX(ROPE_CLIMB_PWM);
	}

	// sets the speed controller to a speed while the encoder count is less than
	// a certain number
	public void moveDistance(double inches) {
		if ((Math.abs(climbEnc.getDistance() - inches) < ERROR_ALLOWED)) {
			ropeSpeed.stopMotor();
			isFinished = true;
		}
		
		double validSpeed;
		switch (getMotorProgress(inches)) {

		
		// Fast speed
		case 0:
			validSpeed =  ensureRange(1 * SPEED_MULTIPLIER, -1, 1);
			ropeSpeed.set(validSpeed);
			break;
		
		// Medium speed
		case 1:
			validSpeed = ensureRange(0.7 * SPEED_MULTIPLIER, -1, 1);
			ropeSpeed.set(validSpeed);
			break;

		// Slow speed
		case 2:
			validSpeed = ensureRange(0.3 * SPEED_MULTIPLIER, -1, 1);
			ropeSpeed.set(validSpeed);
			break;
		}
	}

	// resets the encoder count and sets the speed controller to 0
	public void resetWinch() {

	}

	public int getEncoder() {
		return climbEnc.get();
	}

	// resets the encoder count
	public void resetEncoder() {
		climbEnc.reset();
	}

	// Returns how far the motor has traveled
	private int getMotorProgress(double inchesToMove) {
		double inches = climbEnc.getDistance();
		
		if((0.83333 * inchesToMove) < inches){
			//Slow motor speed is used
			return 2;
		}
		else if((0.6666 * inchesToMove) < inches){
			//Medium motor speed is used
			return 1;
		}
		else{
			//Fast motor speed is used
			return 0;
		}
		
	}

	// ensures the speed value is between -1.0 and 1.0
	private double ensureRange(double value, double min, double max) {
		return Math.min(Math.max(value, min), max);

	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}