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


import org.usfirst.frc3707.Creedence.Configuration.Constants;
import org.usfirst.frc3707.Creedence.commands.cargo.CargoDeliveryCommand;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class CargoDeliverySubsystem extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private PWMVictorSPX cargoDeliveryLeftMotor;
    private PWMVictorSPX cargoDeliveryRightMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public CargoDeliverySubsystem() {
        cargoDeliveryLeftMotor = new PWMVictorSPX(Constants.CargoDeliverySystem.getLeftMotorControllerPWMChannel());
        addChild("leftSpit", cargoDeliveryLeftMotor);
        cargoDeliveryLeftMotor.setInverted(Constants.CargoDeliverySystem.getLeftMotorControllerInverted());

        cargoDeliveryRightMotor = new PWMVictorSPX(Constants.CargoDeliverySystem.getRightMotorControllerPWMChannel());
        addChild("rightSpit", cargoDeliveryRightMotor);
        cargoDeliveryRightMotor.setInverted(Constants.CargoDeliverySystem.getRightMotorControllerInverted());

    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new CargoDeliveryCommand());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void deliverCargo(double deliverySpeed) {
        cargoDeliveryLeftMotor.set(deliverySpeed);
        cargoDeliveryRightMotor.set(-deliverySpeed);

        // This is my idea for handling motor inversion
        // Double stickVal = org.usfirst.frc3707.Creedence.Robot.oi.joystick2.getRawAxis(3);
        // leftSpit.set(invertLeftMotor ? stickVal*-1 : stickVal);
        // rightSpit.set(invertRightMotor ? stickVal*-1 : stickVal);

    }

    public void retrieveCargo(double retrievalSpeed) {

        cargoDeliveryLeftMotor.set(-retrievalSpeed);
        cargoDeliveryRightMotor.set(retrievalSpeed);

        // This is my idea for handling motor inversion
        // Double stickVal = org.usfirst.frc3707.Creedence.Robot.oi.joystick2.getRawAxis(2);
        // leftSpit.set(invertLeftMotor ? stickVal*-1 : stickVal);
        // rightSpit.set(invertRightMotor ? stickVal*-1 : stickVal);

    }
    public void slowDeliverCargo(){
        cargoDeliveryLeftMotor.set(.4);
        cargoDeliveryRightMotor.set(-.4);
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}
