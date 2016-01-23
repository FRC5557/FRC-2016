package org.usfirst.frc.team5557.robot.subsystems;

import org.usfirst.frc.team5557.robot.OI;
import org.usfirst.frc.team5557.robot.RobotMap;
import org.usfirst.frc.team5557.robot.commands.JoystickDriveCommand;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	BuiltInAccelerometer accel = new BuiltInAccelerometer();
	Victor frontLeft = new Victor(6);
	Victor frontRight = new Victor(7);
	Victor rearRight = new Victor(8);
	Victor rearLeft = new Victor(9);
    RobotDrive drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
    
    
	public static double xCalib, yCalib, zCalib;
	public static double sensitivity;  //made for the slider to control the sensitivity of the z-rotation
	public DriveSubsystem() {
    	drive.setInvertedMotor(MotorType.kFrontRight, true); //one
    	drive.setInvertedMotor(MotorType.kRearRight, true); //two
	}
	
	public RobotDrive getDrive() {
		return drive;
	}

	public void initDefaultCommand() {
    	setDefaultCommand(new JoystickDriveCommand());
    }
  
    public void drive()
    {

    	double x = OI.stick.getX()-xCalib;  //reads x on joystick and sets to "x"
    	double y = OI.stick.getY()-yCalib;  //reads y on joystick and sets to "y"
    	double z = OI.stick.getTwist()-zCalib;  //reads z on joystick and sets to "z"
    	sensitivity = OI.stick.getThrottle() + 2;  //reads slider on joystick, plus 2 to change range form (-1,1
    	SmartDashboard.putNumber("Sensitivity", sensitivity);  
    	
    	double magnitude = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) ;  //calculating the magnitude using pythagorean theorem and x and y
    	double direction = Math.toDegrees(Math.atan2(y, x))+90;  //calculating the direction with arctangent of x and y
    	if (direction < 0.0) {direction += 360.0;}  //making direction positive
    	SmartDashboard.putNumber("Direction", direction);  //smartDashoboard set up
    	SmartDashboard.putNumber("Magnitude", magnitude);  //^
    	drive.mecanumDrive_Polar(magnitude, direction, z/sensitivity);  //the actual code causing the driving of the robot
    	
    	//accel currently not in use on the robot
    	double accelX = accel.getX() * 9.8;  //multiplied by gravity because it outputs in G's
    	double accelY = accel.getY() * 9.8;  //same ^
    	
    	//SmartDashoboard set ups
    	SmartDashboard.putNumber("X-Accel", accelX);
    	SmartDashboard.putNumber("Y-Accel", accelY);
    	
    	SmartDashboard.putNumber("X calib", xCalib);
    	SmartDashboard.putNumber("Y calib", yCalib);
    	SmartDashboard.putNumber("Z calib", zCalib);
    	
    	SmartDashboard.putNumber("X-Joy", x);
    	SmartDashboard.putNumber("Y-Joy", y);
    	SmartDashboard.putNumber("Z-Joy", z);
    	
    }
}

