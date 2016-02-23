package org.usfirst.frc.team5557.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class StopShootingMotorsCommand extends Command {

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		IntakeCommand.stop = true;
		ShooterMotorsCommand.stop = true; 
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		if(IntakeCommand.stop && ShooterMotorsCommand.stop){return true;} 
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
