package org.usfirst.frc.team5557.robot.commands;

import org.usfirst.frc.team5557.robot.OI;
import org.usfirst.frc.team5557.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Calibrate extends Command {

    public Calibrate() {
    	execute();
    }

    protected void initialize() {
    }

   public void execute() {
    	DriveSubsystem.xCalib = OI.stick.getX();
    	DriveSubsystem.yCalib = OI.stick.getY();
    	DriveSubsystem.zCalib = OI.stick.getZ();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }
    
    protected void interrupted() {
    }
}
