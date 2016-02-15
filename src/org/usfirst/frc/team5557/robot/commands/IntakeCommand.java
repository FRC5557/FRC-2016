package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeCommand extends Command {

	private boolean reverse;
	private boolean timed;
	private long finishTime;

	public IntakeCommand(boolean reverse) {
		requires(Robot.intake);
		this.reverse = reverse;
		this.timed = false;
	}
	
	public IntakeCommand(boolean reverse, long duration) {
		requires(Robot.intake);
		finishTime = System.currentTimeMillis() + duration;
		timed = true;
	}

	protected void initialize() {
	}

	public void execute() {
		if (reverse)
			Robot.intake.reverse();
		else
			Robot.intake.forward();
	}

	protected boolean isFinished() {
		if(timed && System.currentTimeMillis() >= finishTime) {
			return true;
		}
		return false;
	}

	protected void end() {
		Robot.intake.stop();
	}

	protected void interrupted() {
		end();
	}
}
