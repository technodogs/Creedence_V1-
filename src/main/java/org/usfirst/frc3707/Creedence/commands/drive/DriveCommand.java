// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3707.Creedence.commands.drive;

import org.usfirst.frc3707.Creedence.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveCommand extends Command {

    public DriveCommand() {

        
        requires(Robot.driveSubsystem);

    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.driveSubsystem.enable();
    }

    // Lidar lidarCrab = new Lidar(new DigitalInput(10));

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

        Robot.oi.driveByJoystick(-Robot.oi.driverController.getLeftStickXValue());
        // Robot.driveSubsystem.drive(-Robot.oi.driverController.getLeftStickXValue(), -Robot.oi.driverController.getLeftStickYValue(),
        //             -Robot.oi.driverController.getRightStickXValue(), false,
        //             Robot.oi.driverController.getRightBumperPressed(), Robot.oi.driverController.getXButtonPressed());
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
