package org.usfirst.frc.team5557.robot.subsystems;

import org.usfirst.frc.team5557.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	CANTalon left = new CANTalon(RobotMap.INTAKE_LEFT_MOTOR);
	CANTalon right = new CANTalon(RobotMap.INTAKE_RIGHT_MOTOR);

	public void initDefaultCommand() {
	}

	public void setSpeed(double speed) {
		left.set(-speed);
		right.set(speed);
	}

	public void forward() {
		setSpeed(1);
	}

	public void reverse() {
		setSpeed(-1);
	}

	public void stop() {
		setSpeed(0);
	}
}
