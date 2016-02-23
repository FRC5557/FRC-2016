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
	public static RobotDrive robotDrive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
	
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
		 * robotDrive.setInvertedMotor(MotorType.kFrontRight, true);
		 * robotDrive.setInvertedMotor(MotorType.kRearRight, true);
		 * robotDrive.setInvertedMotor(MotorType.kFrontLeft, true);
		 * robotDrive.setInvertedMotor(MotorType.kRearLeft, true);
		 */
		
		/* Reset values */
		frontLeft.setVoltageRampRate(32);
		frontRight.setVoltageRampRate(32);
		rearRight.setVoltageRampRate(32);
		rearLeft.setVoltageRampRate(32);
		sensorTalon().setPulseWidthPosition(0);
	}

	public RobotDrive getDrive() {
		return robotDrive;
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

		robotDrive.arcadeDrive(y * slowCoefficient(), -z * slowCoefficient());
		
/*		if ((y <= 1) && (y >= .9)){
			frontLeft.set(y * .995);
			rearLeft.set(y * .995);
		}
		if ((y >= -1) && (y <= -.9)){
			frontLeft.set(y * .995);
			rearLeft.set(y * .995);
		}
		else{}
*/
	}

	public void setCalibration(double x, double y, double z) {
		xCalib = x;
		yCalib = y;
		zCalib = z;
	}

	public static void manualDrive(double magnitude, double direction) {
		robotDrive.drive(magnitude, direction);
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
		robotDrive.drive(0, 0);
	}
}
