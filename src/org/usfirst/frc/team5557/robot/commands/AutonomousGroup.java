package org.usfirst.frc.team5557.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousGroup extends CommandGroup {

	public AutonomousGroup() {
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// addSequential(new DriveForTimeCommand(15000, 0.5, 0.0));
		addSequential(new DriveForEncoderCommand(10 * 4100, -.5, 0.0)); // Not
																		// sure
																		// if
																		// this
																		// will
																		// work,
																		// needs
																		// testing
																		// ...
																		// ~Faraz
		addSequential(new TurnCommand(450));
		// Robot.drive.manualDrive(5, 60); //I have no idea if this will work
		// ~Faraz
		// just trying stuff out cuz i dont have a robot to test yet

		// addSequential(new ShootCommand());

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
