package org.usfirst.frc.team5557.robot.subsystems;

import org.usfirst.frc.team5557.robot.OI;
import org.usfirst.frc.team5557.robot.RobotMap;
import org.usfirst.frc.team5557.robot.commands.JoystickDriveCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveSubsystem extends Subsystem {

	private static CANTalon frontLeft = new CANTalon(RobotMap.LEFT_FRONT_MOTOR);
	private static CANTalon frontRight = new CANTalon(RobotMap.RIGHT_FRONT_MOTOR);
	private static CANTalon rearRight = new CANTalon(RobotMap.RIGHT_REAR_MOTOR);
	private static CANTalon rearLeft = new CANTalon(RobotMap.LEFT_REAR_MOTOR);
	public static RobotDrive drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
	
	private double xCalib, yCalib, zCalib;
	
	private DriverStation ds = DriverStation.getInstance();
	private double voltage;
	private double minVoltage = 12;
	private double encoder;

	private static final double ENCODER_CONSTANT = 0.014248780487804875;
	private static final double RAMP_CONSTANT = 0.046656;
	private static final double RAMP_BASE = 1.290994449;

	public DriveSubsystem() {
		/*
		 * drive.setInvertedMotor(MotorType.kFrontRight, true);
		 * drive.setInvertedMotor(MotorType.kRearRight, true);
		 * drive.setInvertedMotor(MotorType.kFrontLeft, true);
		 * drive.setInvertedMotor(MotorType.kRearLeft, true);
		 */
		frontLeft.setVoltageRampRate(10);
		frontRight.setVoltageRampRate(10);
		rearRight.setVoltageRampRate(10);
		rearLeft.setVoltageRampRate(10);
	}

	public RobotDrive getDrive() {
		return drive;
	}

	public void initDefaultCommand() {
		setDefaultCommand(new JoystickDriveCommand());
	}

	public void drive() {
		// Setting calibration values
		double x = OI.stick.getX() - xCalib;
		double y = OI.stick.getY() - yCalib;
		double z = OI.stick.getTwist() - zCalib;
		
		voltage = ds.getBatteryVoltage();
		if (voltage < minVoltage)
			minVoltage = voltage;
		encoder = sensorTalon().getPulseWidthPosition();

		SmartDashboard.putNumber("X calib", xCalib);
		SmartDashboard.putNumber("Y calib", yCalib);
		SmartDashboard.putNumber("Z calib", zCalib);

		SmartDashboard.putNumber("X-Joy", x);
		SmartDashboard.putNumber("Y-Joy", y);
		SmartDashboard.putNumber("Z-Joy", z);

		SmartDashboard.putNumber("Encoder Units", encoder);
		SmartDashboard.putNumber("Encoder (cm)", encoder * ENCODER_CONSTANT);

		SmartDashboard.putNumber("FL Motor", frontLeft.get());
		SmartDashboard.putNumber("FR Motor", frontRight.get());
		SmartDashboard.putNumber("RL Motor", rearLeft.get());
		SmartDashboard.putNumber("RR Motor", rearRight.get());

		/*
		 * NetworkTable server = NetworkTable.getTable("SmartDashboard");
		 * SmartDashboard.putNumber("COG X double",
		 * server.getNumber("/SmartDashboard/COG_X", 0.0));
		 * SmartDashboard.putString("COG X",
		 * (server.getString("/SmartDashboard/COG_X", "0.0")));
		 */

		SmartDashboard.putNumber("Voltage", voltage);
		SmartDashboard.putNumber("Minimum", minVoltage);
		SmartDashboard.putNumber("Time Remaining", ds.getMatchTime());

		drive.arcadeDrive(y * slowCoefficient(), -z * slowCoefficient());

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

	private double slowCoefficient() {
		if (voltage > 12) {
			return 1;
		} else {
			return (RAMP_CONSTANT * Math.pow(RAMP_BASE, voltage));

		}
	}

	public void stop() {
		drive.drive(0, 0);
	}
}
