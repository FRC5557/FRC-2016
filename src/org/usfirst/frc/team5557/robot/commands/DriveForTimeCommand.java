package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForTimeCommand extends Command {

	private long duration;
	private double magnitude;
	private double direction;
	private long startTime;

	public DriveForTimeCommand(long time, double magnitude, double direction) {
		requires(Robot.drive);
		duration = time;
		startTime = System.currentTimeMillis();
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
		if (System.currentTimeMillis() >= (startTime + duration)) {
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drive.stop();
		startTime = System.currentTimeMillis();

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
