// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3707.Creedence;

import org.usfirst.frc3707.Creedence.commands.autonomous.AutoGrabSequence;
import org.usfirst.frc3707.Creedence.commands.drive.*;
import org.usfirst.frc3707.Creedence.commands.hatch.closeClawCommand;
import org.usfirst.frc3707.Creedence.commands.hatch.openClawCommand;
import org.usfirst.frc3707.Creedence.commands.hatch.thrustBackwardCommand;
import org.usfirst.frc3707.Creedence.commands.hatch.thrustForwardCommand;
import org.usfirst.frc3707.Creedence.commands.lift.hatchToBotCommand;
import org.usfirst.frc3707.Creedence.commands.vision.GrabLineCommand;

//import org.usfirst.frc3707.Creedence.commands.slideUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    public class XBoxController {
        private Joystick controller;

        // i think these are off by one
        private static final int leftStickXAxis = 0;
        private static final int leftStickYAxis = 1;
        private static final int leftTriggerAxis = 2;
        private static final int rightTriggerAxis = 3;
        private static final int rightStickXAxis = 4;
        private static final int rightStickYAxis = 5;
        
        private static final int aButtonNumber = 1;
        private static final int bButtonNumber = 2;
        private static final int xButtonNumber = 3;
        private static final int yButtonNumber = 4;

        private static final int leftBumperNumber = 5;
        private static final int rightBumperNumber = 6;

        private static final int leftMenuNumber = 7;
        private static final int rightMenuNumber = 8;

        private static final int leftStickPressNumber = 9;
        private static final int rightStickPressNumber = 10;

        private static final int upDPadAngle = 0;
        private static final int rightDPadAngle = 90;
        private static final int downDPadAngle = 180;
        private static final int leftDPadAngle = 270;

        private JoystickButton aButton;
        private JoystickButton bButton;
        private JoystickButton xButton;
        private JoystickButton yButton;

        private JoystickButton leftBumperButton;
        private JoystickButton rightBumperButton;

        private JoystickButton leftStickPressButton;
        private JoystickButton rightStickPressButton;

        private POVButton dpadUp;
        private POVButton dpadRight;
        private POVButton dpadDown;
        private POVButton dpadLeft;

        public XBoxController(int controllerPort){
            controller = new Joystick(controllerPort);
            aButton = new JoystickButton(controller, aButtonNumber);
            bButton = new JoystickButton(controller, bButtonNumber);
            xButton = new JoystickButton(controller, xButtonNumber);
            yButton = new JoystickButton(controller, yButtonNumber);

            leftBumperButton = new JoystickButton(controller, leftBumperNumber);
            rightBumperButton = new JoystickButton(controller, rightBumperNumber);

            leftStickPressButton =  new JoystickButton(controller, leftStickPressNumber);
            rightStickPressButton = new JoystickButton(controller, rightStickPressNumber);

            dpadUp = new POVButton(controller, upDPadAngle);
            dpadRight = new POVButton(controller, rightDPadAngle);
            dpadDown = new POVButton(controller, downDPadAngle);
            dpadLeft = new POVButton(controller, leftDPadAngle);
        }

        public Joystick getController(){
            return controller;
        }

        public JoystickButton getAButton(){
            return aButton;
        }

        public JoystickButton getBButton(){
            return bButton;
        }

        public JoystickButton getXButton(){
            return xButton;
        }

        public JoystickButton getYButton(){
            return yButton;
        }

        public JoystickButton getLeftBumper(){
            return leftBumperButton;
        }

        public JoystickButton getRightBumper(){
            return rightBumperButton;
        }

        public JoystickButton getLeftStickPress(){
            return leftStickPressButton;
        }

        public JoystickButton getRightStickPress(){
            return rightStickPressButton;
        }

        public POVButton getDPadUp(){
            return dpadUp;
        }

        public POVButton getDPadRight(){
            return dpadRight;
        }

        public POVButton getDPadDown(){
            return dpadDown;
        }

        public POVButton getDPadLeft(){
            return dpadLeft;
        }

        public double getLeftTriggerValue(){
            return controller.getRawAxis(leftTriggerAxis);
        }

        public double getRightTriggerValue(){
            return controller.getRawAxis(rightTriggerAxis);
        }

        public double getLeftStickXValue(){
            return controller.getRawAxis(leftStickXAxis);
        }

        public double getLeftStickYValue(){
            return controller.getRawAxis(leftStickYAxis);
        }

        public double getRightStickXValue(){
            return controller.getRawAxis(rightStickXAxis);
        }

        public double getRightStickYValue(){
            return controller.getRawAxis(rightStickYAxis);
        }

        public boolean getAButtonPressed(){
            return controller.getRawButton(aButtonNumber);
        }

        public boolean getBButtonPressed(){
            return controller.getRawButton(bButtonNumber);
        }

        public boolean getXButtonPressed(){
            return controller.getRawButton(xButtonNumber);
        }

        public boolean getYButtonPressed(){
            return controller.getRawButton(yButtonNumber);
        }

        public boolean getLeftBumperPressed(){
            return controller.getRawButton(leftBumperNumber);
        }

        public boolean getRightBumperPressed(){
            return controller.getRawButton(rightBumperNumber);
        }

        public boolean getLeftMenuButtonPressed(){
            return controller.getRawButton(leftMenuNumber);
        }

        public boolean getRightMenuButtonPressed(){
            return controller.getRawButton(rightMenuNumber);
        }

        
    }

    public XBoxController driverController;
    public XBoxController operatorController;


    public OI() {

        driverController = new XBoxController(0);
        operatorController = new XBoxController(1);

        operatorController.getAButton().whenPressed(new thrustBackwardCommand());
        operatorController.getBButton().whenPressed(new openClawCommand());
        operatorController.getXButton().whenPressed(new closeClawCommand());
        operatorController.getYButton().whenPressed(new thrustForwardCommand());

        operatorController.getDPadDown().whenPressed(new hatchToBotCommand());
        operatorController.getDPadUp().whenPressed(new AutoGrabSequence());

        driverController.getLeftBumper().whenPressed(new GrabLineCommand());

        SmartDashboard.putData("Auto hatch snag Test", new AutoGrabSequence());
        SmartDashboard.putData("Disable Front Right Rotation", new DisableFrontRightRotationCommand());
        SmartDashboard.putData("Disable Front Left Rotation", new DisableFrontLeftRotationCommand());
        SmartDashboard.putData("Disable Back Right Rotation", new DisableBackRightRotationCommand());
        SmartDashboard.putData("Disable Back Left Rotation", new DisableBackLeftRotationCommand());
        SmartDashboard.putData("Grab", new GrabLineCommand());
        
    }

    public void driveByJoystick(double directionX) {
        Robot.driveSubsystem.drive(directionX, -Robot.oi.driverController.getLeftStickYValue(),
                    -Robot.oi.driverController.getRightStickXValue(), false,
                    Robot.oi.driverController.getRightBumperPressed(), Robot.oi.driverController.getXButtonPressed());
    }
}
