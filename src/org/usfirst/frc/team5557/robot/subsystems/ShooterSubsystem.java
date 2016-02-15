package org.usfirst.frc.team5557.robot.subsystems;

import org.usfirst.frc.team5557.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	CANTalon left = new CANTalon(RobotMap.SHOOTER_LEFT_MOTOR);
	CANTalon right = new CANTalon(RobotMap.SHOOTER_RIGHT_MOTOR);

	public void initDefaultCommand() {
	}

	public void spin() {
		left.set(-1);
		right.set(1);
	}

	public void stop() {
		left.set(0);
		right.set(0);
	}
}
