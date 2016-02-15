package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeCommand extends Command {

	private boolean reverse;

	public IntakeCommand(boolean reverse) {
		requires(Robot.intake);
		this.reverse = reverse;
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
		return false;
	}

	protected void end() {
		Robot.intake.stop();
	}

	protected void interrupted() {
		end();
	}
}
