package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForEncoderCommand extends Command {

	private double distance;
	public static int encoderInitial;
	private double magnitude;
	private double direction;

	public DriveForEncoderCommand(double distance, double magnitude, double direction) {
		requires(Robot.drive);
		this.distance = distance;
		this.magnitude = magnitude;
		this.direction = direction;
		encoderInitial = Robot.drive.sensorTalon().getPulseWidthPosition();
		Robot.drive.sensorTalon().clearIAccum();
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
		if (Math.abs(Robot.drive.sensorTalon().getPulseWidthPosition() - encoderInitial) >= distance) {
			TurnCommand.encoderInitial = Robot.drive.sensorTalon().getPulseWidthPosition();
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
