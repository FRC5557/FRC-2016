package org.usfirst.frc.team5557.robot.subsystems;

import org.usfirst.frc.team5557.robot.OI;
import org.usfirst.frc.team5557.robot.RobotMap;
import org.usfirst.frc.team5557.robot.commands.JoystickDriveCommand;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveSubsystem extends Subsystem {

	private BuiltInAccelerometer accel = new BuiltInAccelerometer();
	private CANTalon frontLeft = new CANTalon(RobotMap.LEFT_FRONT_MOTOR);
	private CANTalon frontRight = new CANTalon(RobotMap.RIGHT_FRONT_MOTOR);
	private CANTalon rearRight = new CANTalon(RobotMap.RIGHT_REAR_MOTOR);
	private CANTalon rearLeft = new CANTalon(RobotMap.LEFT_REAR_MOTOR);
	private RobotDrive drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
	private double xCalib, yCalib, zCalib;

	public DriveSubsystem() {
		drive.setInvertedMotor(MotorType.kFrontRight, true);
		drive.setInvertedMotor(MotorType.kRearRight, true);
		drive.setInvertedMotor(MotorType.kFrontLeft, true);
		drive.setInvertedMotor(MotorType.kRearLeft, true);
	}

	public RobotDrive getDrive() {
		return drive;
	}

	public void initDefaultCommand() {
		setDefaultCommand(new JoystickDriveCommand());
	}

	public void drive() {
		// Setting calibration values
		double x = OI.stick.getX() - xCalib; // reads x on joystick and sets to
												// "x"
		double y = OI.stick.getY() - yCalib; // reads y on joystick and sets to
												// "y"
		double z = OI.stick.getTwist() - zCalib; // reads z on joystick and sets
													// to "z"

		drive.arcadeDrive(y, x, true); // the actual code causing the driving of
										// the robot

		// accel currently NOT IN USE for robot
		double accelX = accel.getX() * 9.8; // multiplied by gravity because it
											// outputs in G's
		double accelY = accel.getY() * 9.8; // same ^

		// SmartDashoboard debug information
		SmartDashboard.putNumber("X-Accel", accelX);
		SmartDashboard.putNumber("Y-Accel", accelY);

		SmartDashboard.putNumber("X calib", xCalib);
		SmartDashboard.putNumber("Y calib", yCalib);
		SmartDashboard.putNumber("Z calib", zCalib);

		SmartDashboard.putNumber("X-Joy", x);
		SmartDashboard.putNumber("Y-Joy", y);
		SmartDashboard.putNumber("Z-Joy", z);
	}

	public void setCalibration(double x, double y, double z) {
		xCalib = x;
		yCalib = y;
		zCalib = z;
	}

	public void manualDrive(double magnitude, double direction) {
		drive.drive(magnitude, direction);
	}

	public CANTalon sensorTalon() {
		return frontLeft;
	}

	public void stop() {
		drive.drive(0, 0);
	}
}
