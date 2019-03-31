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


import org.usfirst.frc3707.Creedence.commands.autonomousCommands.commandGroup;
import org.usfirst.frc3707.Creedence.commands.hatchCommands.closeClaw;
import org.usfirst.frc3707.Creedence.commands.hatchCommands.openClaw;
import org.usfirst.frc3707.Creedence.commands.hatchCommands.thrustBackward;
import org.usfirst.frc3707.Creedence.commands.hatchCommands.thrustForward;
import org.usfirst.frc3707.Creedence.commands.liftCommands.hatchToBot;
import org.usfirst.frc3707.Creedence.commands.visionCommands.GrabLine;

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
    public Joystick joystick1;
    public JoystickButton b;
    public JoystickButton a;
    public JoystickButton x;
    public JoystickButton lb;
    public Joystick joystick2;
    public JoystickButton y;
    public POVButton up; 
    public POVButton down; 
    public POVButton left;
    //public JoystickButton select; dont use untill pneumatic lift installed
    //public JoystickButton start; ""


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        joystick2 = new Joystick(1);
        //left = new POVButton(joystick2, 270, 0);
        down = new POVButton(joystick2, 180, 0);
        //up = new POVButton(joystick2, 0, 0);
        b = new JoystickButton(joystick2, 2);
        y = new JoystickButton(joystick2, 4);
        a = new JoystickButton(joystick2, 1);
        x = new JoystickButton(joystick2, 3);
        b.whenPressed(new openClaw());
        joystick1 = new Joystick(0);
        y.whenPressed(new thrustForward());
        x.whenPressed(new closeClaw());
        a.whenPressed(new thrustBackward());
        //up.whenPressed(new hatchToMid());
        down.whenPressed(new hatchToBot());
        //left.whenPressed(new ballToBottom());

        //select.whenPressed(new slideUp());
        
        lb = new JoystickButton(joystick1, 5);

        lb.whenPressed(new GrabLine());

        // SmartDashboard Buttons
        // SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        // SmartDashboard.putData("Drive", new Drive());
        // SmartDashboard.putData("succ", new succ());
        // SmartDashboard.putData("Shoot", new Shoot());
        // SmartDashboard.putData("spread", new spread());
        // SmartDashboard.putData("RaiseToHeight", new RaiseToHeight());
        // SmartDashboard.putData("Middle Position", new hatchToMid());
        // SmartDashboard.putData("Bottom Position", new hatchToBot());
        // SmartDashboard.putData("Grab Disk And Line up n stuff", new commandGroup());
        SmartDashboard.putData("Auto hatch snag Test", new commandGroup());

        // SmartDashboard.putData("Disable Back Left Angle", new swerve_disableBLAngle());
        // SmartDashboard.putData("Disable Back Left Drive", new swerve_disableBLDrive());
        // SmartDashboard.putData("Disable Back Right Angle", new swerve_disableBRAngle());
        // SmartDashboard.putData("Disable Back Right Drive", new swerve_disableBRDrive());
        // SmartDashboard.putData("Disable Front Right Angle", new swerve_disableFRAngle());

        // SmartDashboard.putData("thrustInAndOut", new thrustInAndO
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick1() {
        return joystick1;
    }

    public Joystick getJoystick2() {
        return joystick2;
    }
    

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
