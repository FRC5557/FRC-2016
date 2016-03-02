package org.usfirst.frc.team5557.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

import org.usfirst.frc.team5557.robot.commands.ShootCommand;

public class AutonomousGroup extends CommandGroup {

	public AutonomousGroup() {
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// addSequential(new DriveForTimeCommand(150
		//addSequential(new DriveForEncoderCommand(10.9 * 4100, -.35, 0.00001)); 

		addSequential(new DriveForEncoderCommand(8 * 4100, -.38, 0.00001)); 
		//addSequential(new TurnCommand(86.15));
		addSequential(new TurnCommand(170));
		//addSequential(new DriveForEncoderCommand(.2 * 4100, .38, 0.00001)); 
		addSequential(new ShootCommand());
		

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
	}
}
