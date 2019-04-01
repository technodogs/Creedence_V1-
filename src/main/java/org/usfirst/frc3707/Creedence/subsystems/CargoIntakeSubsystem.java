// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3707.Creedence.subsystems;

import org.usfirst.frc3707.Creedence.Robot;
import org.usfirst.frc3707.Creedence.Configuration.Constants;
import org.usfirst.frc3707.Creedence.commands.cargo.CargoIntakeCommand;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CargoIntakeSubsystem extends Subsystem {

    private PWMVictorSPX cargoSucc;
    private DoubleSolenoid tonguePneumatic = new DoubleSolenoid(Constants.PneumaticSystem.getPcmCanId(), Constants.CargoIntakeSystem.getTongueSolenoidForward(), Constants.CargoIntakeSystem.getTongueSolenoidReverse());

    public CargoIntakeSubsystem() {
        cargoSucc = new PWMVictorSPX(Constants.CargoIntakeSystem.getMotorControllerPWMChannel());
        addChild("cargoSucc", cargoSucc);
        cargoSucc.setInverted(Constants.CargoIntakeSystem.getMotorControllerInverted());

    }

    @Override
    public void initDefaultCommand() {

        setDefaultCommand(new CargoIntakeCommand());
    }

    public void moveTongueOut() {
        tonguePneumatic.set(Value.kForward);
    }
    public void moveTongueIn() {
        tonguePneumatic.set(Value.kReverse);
    }

    public void collectCargo(double value) {

        cargoSucc.set(value);
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }


}
