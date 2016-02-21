package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;
import org.usfirst.frc.team5557.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;

public class TurnCommand extends Command {

	private RobotDrive drive = DriveSubsystem.drive;
	int theta;
	int encoderInitial;
	int time;

	public TurnCommand(int degrees) {
		theta = degrees;
		encoderInitial = Robot.drive.sensorTalon().getPulseWidthPosition();
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		drive.arcadeDrive(0, 1);
	}

	@Override
	protected boolean isFinished() {

		if (Math.abs(Robot.drive.sensorTalon().getPulseWidthPosition() - encoderInitial) >= (theta / 360) * 13440) {
			return true;
		}
		// Faraz did the math. 6720 units corresponds to 360 degrees of
		// rotation.
		// based on the fact that the radius of rotation is 12 inches (75.4 in
		// circumference)
		// while the wheels are 23 in, so 4100 points corresponds to 23 inches
		// along the floor;
		// set up a proportion: 4100 / 23 = 13440 / 75.4

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
