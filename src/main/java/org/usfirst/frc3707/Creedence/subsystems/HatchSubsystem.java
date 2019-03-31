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

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class HatchSubsystem extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private Compressor compressor = new Compressor(Constants.PneumaticSystem.getPcmCanId());
    private DoubleSolenoid clawClamp = new DoubleSolenoid(Constants.PneumaticSystem.getPcmCanId(), Constants.HatchSystem.getClampSolenoidForward(), Constants.HatchSystem.getClampSolenoidReverse());
    private DoubleSolenoid thrust = new DoubleSolenoid(Constants.PneumaticSystem.getPcmCanId(), Constants.HatchSystem.getThrustSolenoidForward(), Constants.HatchSystem.getThrustSolenoidReverse());
    private DigitalInput clawButton1 = new DigitalInput(Constants.HatchSystem.getClawButton1());
    private DigitalInput clawButton2 = new DigitalInput(Constants.HatchSystem.getClawButton2());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public HatchSubsystem() {

        addChild("Compressor ", compressor);
    }

    public void thrust() {
        if (Robot.oi.joystick2.getRawButton(2) == true) {
            if (thrust.get() == Value.kReverse) {
                thrust.set(Value.kForward);
            } else {
                thrust.set(Value.kReverse);
            }
        }
    }

    public void spread() {
        if (Robot.oi.joystick2.getRawButton(4) == true) {
            if (clawClamp.get() == Value.kReverse) {
                clawClamp.set(Value.kForward);
            } else {
                clawClamp.set(Value.kReverse);
            }
        }
    }
    public void openClaw(){
        clawClamp.set(Value.kForward);
    }
    public void closeClaw(){
        clawClamp.set(Value.kReverse);
    }
    public void thrustForward(){
        thrust.set(Value.kForward);
    }
    public void thrustBackward(){
        thrust.set(Value.kReverse);
    }

    public Boolean getButton1(){
        return !clawButton1.get();
    }

    public Boolean getButton2(){
        return !clawButton2.get();
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
        SmartDashboard.putBoolean("Butt1", clawButton1.get());
        SmartDashboard.putBoolean("Butt2", clawButton2.get());
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}
