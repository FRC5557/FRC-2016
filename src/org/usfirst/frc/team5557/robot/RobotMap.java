package org.usfirst.frc.team5557.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// Drive train motors
	public static final int LEFT_FRONT_MOTOR = 7;
	public static final int LEFT_REAR_MOTOR = 6;
	public static final int RIGHT_FRONT_MOTOR = 5;
	public static final int RIGHT_REAR_MOTOR = 4;

	// Shooter/intake motors
	public static final int INTAKE_LEFT_MOTOR = 8;
	public static final int INTAKE_RIGHT_MOTOR = 3;
	public static final int SHOOTER_LEFT_MOTOR = 1;
	public static final int SHOOTER_RIGHT_MOTOR = 2;
	
	public static final int ARM_MOTOR = 9; 
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
