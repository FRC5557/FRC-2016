package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.OI;
import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CalibrateCommand extends Command {

	public CalibrateCommand() {
		requires(Robot.drive);
	}

	protected void initialize() {
	}

	public void execute() {
		// updates the rest position of the robot to the x,y,z coordinates of
		// the joystick
		Robot.drive.setCalibration(OI.stick.getX(), OI.stick.getY(), OI.stick.getZ());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
