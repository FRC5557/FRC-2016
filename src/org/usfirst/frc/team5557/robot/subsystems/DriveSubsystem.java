package org.usfirst.frc.team5557.robot.subsystems;

import org.usfirst.frc.team5557.robot.RobotMap;
import org.usfirst.frc.team5557.robot.commands.JoystickDriveCommand;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	BuiltInAccelerometer accelerometer = new BuiltInAccelerometer();
	RobotDrive drive;
	
	public DriveSubsystem() {
		drive = new RobotDrive(RobotMap.LEFT_FRONT_MOTOR, RobotMap.LEFT_REAR_MOTOR,
				RobotMap.RIGHT_FRONT_MOTOR, RobotMap.RIGHT_REAR_MOTOR);
	}
	
	public RobotDrive getDrive() {
		return drive;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new JoystickDriveCommand());
    }
}

