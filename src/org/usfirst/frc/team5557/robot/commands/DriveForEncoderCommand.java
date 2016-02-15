package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForEncoderCommand extends Command {

	private int encoderPosition;
	private double magnitude;
	private double direction;

	public DriveForEncoderCommand(int encoderPosition, double magnitude, double direction) {
		requires(Robot.drive);
		this.encoderPosition = encoderPosition;
		this.magnitude = magnitude;
		this.direction = direction;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drive.manualDrive(magnitude, direction);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (Robot.drive.sensorTalon().getPulseWidthPosition() >= encoderPosition) {
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drive.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
