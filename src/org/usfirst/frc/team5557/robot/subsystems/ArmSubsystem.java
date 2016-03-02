package org.usfirst.frc.team5557.robot.subsystems;

import org.usfirst.frc.team5557.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;


public class ArmSubsystem extends Subsystem {

	CANTalon arm = new CANTalon(RobotMap.ARM_MOTOR);


	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}

	public void setSpeed(double speed){
		
		arm.set(speed);
	}

	public void move(double speed) {
		setSpeed(speed);
	}
	

	public void stop() {
		setSpeed(0);
	}
	
}
