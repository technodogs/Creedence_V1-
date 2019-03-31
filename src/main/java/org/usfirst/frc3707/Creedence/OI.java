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
import org.usfirst.frc3707.Creedence.commands.hatch.closeClaw;
import org.usfirst.frc3707.Creedence.commands.hatch.openClaw;
import org.usfirst.frc3707.Creedence.commands.hatch.thrustBackward;
import org.usfirst.frc3707.Creedence.commands.hatch.thrustForward;
import org.usfirst.frc3707.Creedence.commands.lift.hatchToBot;
import org.usfirst.frc3707.Creedence.commands.vision.GrabLine;

//import org.usfirst.frc3707.Creedence.commands.slideUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import edu.wpi.first.wpilibj.command.Command;
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
    
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

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

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public XBoxController driverController;
    public XBoxController operatorController;
    public POVButton up; 
    public POVButton down; 
    public POVButton left;
    //public JoystickButton select; dont use untill pneumatic lift installed
    //public JoystickButton start; ""


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        driverController = new XBoxController(0);
        operatorController = new XBoxController(1);

        operatorController.getAButton().whenPressed(new thrustBackward());
        operatorController.getBButton().whenPressed(new openClaw());
        operatorController.getXButton().whenPressed(new closeClaw());
        operatorController.getYButton().whenPressed(new thrustForward());

        operatorController.getDPadDown().whenPressed(new hatchToBot());

        driverController.getLeftBumper().whenPressed(new GrabLine());

        SmartDashboard.putData("Auto hatch snag Test", new AutoGrabSequence());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS    

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
