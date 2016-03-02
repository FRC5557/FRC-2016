package org.usfirst.frc.team5557.robot;

import org.usfirst.frc.team5557.robot.commands.*;

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

	public static Button button1 = new JoystickButton(stick, 1);
	public static Button button2 = new JoystickButton(stick, 2);
	public static Button button5 = new JoystickButton(stick, 5);
	public static Button button11 = new JoystickButton(stick, 11);
	public static Button button12 = new JoystickButton(stick, 12);

	public static Button button4 = new JoystickButton(stick, 4);
	public static Button button6 = new JoystickButton(stick, 6);
	public OI() {
		button1.whenPressed(new ShootCommand()); // shoot
		button2.whenPressed(new StopShootingMotorsCommand()); // calibrate
		button5.whileHeld(new ShooterMotorsCommand()); // spin shooter
		button11.whileHeld(new IntakeCommand(false)); // out
		button12.whileHeld(new IntakeCommand(true)); // in
		
		button4.whileHeld(new MoveArmCommand(.3));
		button6.whileHeld(new MoveArmCommand(.3));
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