
package org.usfirst.frc.team5557.robot;

import org.usfirst.frc.team5557.robot.commands.AutonomousGroup;
import org.usfirst.frc.team5557.robot.commands.CalibrateCommand;
import org.usfirst.frc.team5557.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team5557.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team5557.robot.subsystems.ShooterSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final DriveSubsystem drive = new DriveSubsystem();
	public static final ShooterSubsystem shooter = new ShooterSubsystem();
	public static final IntakeSubsystem intake = new IntakeSubsystem();
	public static final CalibrateCommand calibrateCommand = new CalibrateCommand();
	public static OI oi;

	Command autonomousCommand;
	SendableChooser chooser;

	public void robotInit() {
		oi = new OI();

		chooser = new SendableChooser();
		chooser.addDefault("Forward 3s", new AutonomousGroup());
		// SmartDashboard.putData("Autonomous", chooser);
		autonomousCommand = new AutonomousGroup();
	}

	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		calibrateCommand.execute();
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	public void disabledInit() {
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		autonomousCommand = new AutonomousGroup();// (Command)
													// chooser.getSelected();
		autonomousCommand.start();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void testPeriodic() {
		LiveWindow.run();
	}
}
