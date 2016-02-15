package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShooterMotorsCommand extends Command {
	
	private long finishTime;
	private boolean timed;

	public ShooterMotorsCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.shooter);
		timed = false;
	}
	
	public ShooterMotorsCommand(long duration) {
		requires(Robot.shooter);
		timed = true;
		finishTime = System.currentTimeMillis() + duration;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.shooter.spin();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if(timed && System.currentTimeMillis() >= finishTime) {
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.shooter.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}