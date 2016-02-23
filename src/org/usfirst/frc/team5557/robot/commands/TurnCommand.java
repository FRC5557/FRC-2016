/*package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;
import org.usfirst.frc.team5557.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;

public class TurnCommand extends Command {

	int theta;
	int encoderInitial;
	int time;

	public TurnCommand(int degrees) {
		theta = degrees;
		encoderInitial = Robot.drive.sensorTalon().getPulseWidthPosition();
		Robot.drive.sensorTalon().clearIAccum();
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.drive.manualDrive(0, 1);
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
*/

package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.Robot;
import org.usfirst.frc.team5557.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TurnCommand extends Command {
	double theta;
	public static int encoderInitial;

	public TurnCommand(double angle) {
		requires(Robot.drive);
		theta = angle;
		encoderInitial = Robot.drive.sensorTalon().getPulseWidthPosition();
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		//SmartDashboard.putNumber("execute", 4.4);
		DriveSubsystem.manualDrive(-0.5, -0.5);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {

		//SmartDashboard.putNumber("called", Robot.drive.sensorTalon().getPulseWidthPosition());

		//SmartDashboard.putNumber("cutoff", (theta / 360.0) * 13440.0);
		if (Math.abs(Robot.drive.sensorTalon().getPulseWidthPosition() - encoderInitial) >= (theta / 360.0) * 13440.0) {
			DriveForEncoderCommand.encoderInitial = Robot.drive.sensorTalon().getPulseWidthPosition();
			return true;
		}
		//SmartDashboard.putNumber("false", 4.4);
		return false;
	}
	// Called once after isFinished returns true
	protected void end() {

		//SmartDashboard.putNumber("stopped", 0.0);
		Robot.drive.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
