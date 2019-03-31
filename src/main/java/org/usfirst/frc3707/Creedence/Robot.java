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

import org.usfirst.frc3707.Creedence.subsystems.DriveSubsystem;
import org.usfirst.frc3707.Creedence.subsystems.SPIpixy;
import org.usfirst.frc3707.Creedence.subsystems.CargoIntakeSubsystem;
import org.usfirst.frc3707.Creedence.subsystems.ClimbSubsystem;
import org.usfirst.frc3707.Creedence.subsystems.HatchSubsystem;
import org.usfirst.frc3707.Creedence.subsystems.LiftSubsystem;
import org.usfirst.frc3707.Creedence.commands.drive.DriveCommand;
import org.usfirst.frc3707.Creedence.subsystems.CargoDeliverySubsystem;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.cscore.VideoSource.ConnectionStrategy;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {

    Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();

    public static OI oi;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveSubsystem driveSubsystem;
    public static LiftSubsystem liftSubsystem;
    public static CargoIntakeSubsystem cargoIntakeSubsystem;
    public static CargoDeliverySubsystem cargoDeliverySubsystem;
    public static HatchSubsystem hatchSubsystem;
    public static ClimbSubsystem climbSubsystem;

    private static VideoSink server;
    private static UsbCamera camera1;
    private static UsbCamera camera2;

    private int lastButton = 1;

    public static SPIpixy m_pixy;

    //public static PneumaticLift pneumaticLift; dont use untill pneumatic lift is installed

    /**
     * This function is run when the robot is first started up and should be used
     * for any initialization code.
     */
    @Override
    public void robotInit() {

        m_pixy = new SPIpixy();

        camera1 = CameraServer.getInstance().startAutomaticCapture(0); //use for camera on smart Dashboard
        camera2 = CameraServer.getInstance().startAutomaticCapture(1);

        server = CameraServer.getInstance().addSwitchedCamera("switched camera");
        
        camera1.setConnectionStrategy(ConnectionStrategy.kKeepOpen);
        camera2.setConnectionStrategy(ConnectionStrategy.kKeepOpen);



        camera1.setResolution(160, 120);
        camera1.setFPS(30);

        camera2.setResolution(160, 120);
        camera2.setFPS(30);


        driveSubsystem = new DriveSubsystem();
        liftSubsystem = new LiftSubsystem();
        cargoIntakeSubsystem = new CargoIntakeSubsystem();
        cargoDeliverySubsystem = new CargoDeliverySubsystem();
        driveSubsystem.init();
        hatchSubsystem = new HatchSubsystem();
        climbSubsystem = new ClimbSubsystem();

        // OI must be constructed after subsystems. If the OI creates Commands
        // (which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();
    }

    /**
     * This function is called when the disabled button is hit. You can use it to
     * reset subsystems before shutting down.
     */
    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null)
            autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {

        /*if (!lastButton)
        {
            if (oi.joystick1.getRawButton(1))
            {
                lastButton = true;
                server.setSource(camera1);
            }
            else if (oi.joystick1.getRawButton(2))
            {
                lastButton = true;
                server.setSource(camera2);
            }
        }*/
        boolean joystickButton1 = oi.driverController.getAButtonPressed();
        boolean joystickButton2 = oi.driverController.getBButtonPressed();

        if (joystickButton1 && lastButton != 1)
        {
            server.setSource(camera1);
            System.out.println("Switching to Camea One");
        }
        else if (joystickButton2 && lastButton != 2)
        {
            server.setSource(camera2);
            System.out.println("Switching to Camera Two");
        }

        if (joystickButton1)
        {
            lastButton = 1;
        }
        else if (joystickButton2)
        {
            lastButton = 2;
        }
        else
        {
            lastButton = 0;
        }


        

        Scheduler.getInstance().run();
    }
}
