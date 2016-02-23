package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeCommand extends Command {

	private boolean reverse;
	private boolean timed;
	private double duration;
	public static boolean stop;
	public IntakeCommand(boolean reverse) {
		requires(Robot.intake);
		this.reverse = reverse;
		this.timed = false;
		stop = false;
	}

	public IntakeCommand(boolean reverse, double duration) {
		requires(Robot.intake);
		this.duration = duration;
		timed = true;
		stop = false; 
	}
	

	protected void initialize() {
		if (timed)
			setTimeout(duration);
		stop = false; 
	}

	public void execute() {
		if (reverse)
			Robot.intake.reverse();
		else
			Robot.intake.forward();
	}

	protected boolean isFinished() {
		if(stop){ return true;} 
		if (timed) {
			return isTimedOut();
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
