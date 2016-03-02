package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveArmCommand extends Command {
	double speed;
	public MoveArmCommand(double s)
	{
		requires(Robot.arm);
		speed = s;
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub[[s
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.arm.move(speed);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
