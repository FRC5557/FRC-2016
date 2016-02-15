package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForTimeCommand extends Command {

	private double magnitude;
	private double direction;
	private long finishTime;

	public DriveForTimeCommand(long duration, double magnitude, double direction) {
		requires(Robot.drive);
		finishTime = System.currentTimeMillis() + duration;
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
		if (System.currentTimeMillis() >= finishTime) {
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
