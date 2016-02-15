package org.usfirst.frc.team5557.robot;

import org.usfirst.frc.team5557.robot.commands.CalibrateCommand;
import org.usfirst.frc.team5557.robot.commands.IntakeCommand;
import org.usfirst.frc.team5557.robot.commands.KowabungaCommand;
import org.usfirst.frc.team5557.robot.commands.ShooterMotorsCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	public static final Joystick stick = new Joystick(0);

	/*
	 * buttons that need to be programmed: one for intake and holding - rotating
	 * wheel and holding - on the trigger trigger keeps wheels running side
	 * button - shooting fire the shooting while ball still down intake wheels
	 * fire as fast as possible
	 */

	public static Button button5 = new JoystickButton(stick, 5); // for intake
	public static Button button2 = new JoystickButton(stick, 2); // for
																	// calibration
	public static Button button3 = new JoystickButton(stick, 3); // for forward
																	// intake
	public static Button button1 = new JoystickButton(stick, 1); // triggers shoot command
	public static Button button7 = new JoystickButton(stick, 7); // ignore

	public OI() {
		button5.whileHeld(new IntakeCommand(true)); // out
		button2.whileHeld(new CalibrateCommand());
		button3.whileHeld(new IntakeCommand(false)); // in
		button1.whenPressed(new KowabungaCommand());

	}

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}

/*
 * button7.whileHeld(new SpinShooterMotorsCommand()); button7.whileHeld(new
 * IntakeCommand(false));
 */