// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3707.Creedence.commands;

import java.util.ArrayDeque;
import java.util.ArrayList;

import org.usfirst.frc3707.Creedence.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class hatchToPStation extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public hatchToPStation() {

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.liftSystem);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    ArrayDeque<Double> errorDeque = new ArrayDeque<Double>();

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.liftSystem.liftController.enable();
        Robot.liftSystem.liftController.setSetpoint(34.0);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.liftSystem.getLiftHeight();
        //SmartDashboard.putNumber("Lidar error", Robot.liftSystem.liftController.getError());
    }

    // Make this return true when this Command no longer needs to run execute()
    int counter = 0;
    @Override
    protected boolean isFinished() {
        if (Robot.liftSystem.getLiftHeight() > 59) {
            return true;
        }
        return Robot.liftSystem.liftController.onTarget();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.liftSystem.liftController.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
