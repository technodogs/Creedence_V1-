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
import org.usfirst.frc3707.Creedence.PIDInts.Constants;
import org.usfirst.frc3707.Creedence.commands.Drive;
import org.usfirst.frc3707.Creedence.swerve.SwerveDrive;
import org.usfirst.frc3707.Creedence.swerve.SwerveWheel;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem {

    NetworkTableEntry x_pos;
    double[] realx_pos;
    NetworkTableEntry x0;
    NetworkTableEntry x1;

    double[] real_x0Array;
    double[] real_x1Array;

    double error;

    NetworkTableInstance inst = NetworkTableInstance.getDefault();;

    NetworkTable pixyData = inst.getTable("PixyData");;
    double[] defaultValue = { -1 };
    double[] lastError = new double[10];

    private AnalogPotentiometer frontRightEncoder = new AnalogPotentiometer(Constants.FREncoder, 360.0, 0.0);
    private VictorSP frontRightSwerve = new VictorSP(Constants.FRSwerve);
    private PIDController frontRightTwist = new PIDController(0.05, 0.0, 0.0, 0.0, frontRightEncoder, frontRightSwerve,
            0.02);
    private AnalogPotentiometer frontLeftEncoder = new AnalogPotentiometer(Constants.FLEncoder, 360.0, 0.0);;
    private VictorSP frontLeftSwerve = new VictorSP(Constants.FLSwerve);
    private PIDController frontLeftTwist = new PIDController(0.05, 0.0, 0.0, 0.0, frontLeftEncoder, frontLeftSwerve,
            0.02);;
    private AnalogPotentiometer backRightEncoder = new AnalogPotentiometer(Constants.BREncoder, 360.0, 0.0);
    private VictorSP backRightSwerve = new VictorSP(Constants.BrSwerve);
    private PIDController backRightTwist = new PIDController(0.05, 0.0, 0.0, 0.0, backRightEncoder, backRightSwerve,
            0.02);
    private AnalogPotentiometer backLeftEncoder = new AnalogPotentiometer(Constants.BLEncoder, 360.0, 0.0);
    private VictorSP backLeftSwerve = new VictorSP(Constants.BLSwerve);
    private PIDController backLeftTwist = new PIDController(0.05, 0.0, 0.0, 0.0, backLeftEncoder, backLeftSwerve, 0.02);
    private VictorSP frontRightDrive = new VictorSP(Constants.FRDrive);
    private VictorSP frontLeftDrive = new VictorSP(Constants.FLDrive);
    private VictorSP backRightDrive = new VictorSP(Constants.BRDrive);
    private VictorSP backLeftDrive = new VictorSP(Constants.BLDrive);

    // private ADXRS450_Gyro gyro = new ADXRS450_Gyro();
    // Practice Bot Offsets
    // double frontRightOffset = 302;
    // double frontLeftOffset = 117;
    // double backRightOffset = 278;
    // double backLeftOffset = 312;

    // COMP Bot Offsets
    double frontRightOffset = 235;
    double frontLeftOffset = 137;
    double backRightOffset = 271;
    double backLeftOffset = 276;

    
    private SwerveWheel frontRightWheel = new SwerveWheel(frontRightTwist, frontRightDrive, frontRightOffset);
    private SwerveWheel frontLeftWheel = new SwerveWheel(frontLeftTwist, frontLeftDrive, frontLeftOffset);
    private SwerveWheel backRightWheel = new SwerveWheel(backRightTwist, backRightDrive, backRightOffset);
    private SwerveWheel backLeftWheel = new SwerveWheel(backLeftTwist, backLeftDrive, backLeftOffset);
    public SwerveDrive swerve = new SwerveDrive(frontRightWheel, frontLeftWheel, backLeftWheel, backRightWheel, null);

    // LiveWindow.addSensor("Sensors", "gyro", gyro);

    double lidarInches = 0;

    public void init() {
        frontRightTwist.setInputRange(0.0, 360.0);
        frontRightTwist.setOutputRange(-1.0, 1.0);
        frontRightTwist.setContinuous(true);

        frontLeftTwist.setInputRange(0.0, 360.0);
        frontLeftTwist.setOutputRange(-1.0, 1.0);
        frontLeftTwist.setContinuous(true);

        backLeftTwist.setInputRange(0.0, 360.0);
        backLeftTwist.setOutputRange(-1.0, 1.0);
        backLeftTwist.setContinuous(true);

        backRightTwist.setInputRange(0.0, 360.0);
        backRightTwist.setOutputRange(-1.0, 1.0);
        backRightTwist.setContinuous(true);

        backRightSwerve.isAlive();
        backLeftSwerve.isAlive();        
        // gyro.reset();

    }

    // SAVED MOTOR DECLARATIONS

    /**
     * Enables motors. bcuz it werkz?
     */
    public void enable() {
        frontLeftTwist.enable();
        frontRightTwist.enable();
        backLeftTwist.enable();
        backRightTwist.enable();
        System.out.println("Enable Twist");
    }

    /**
     * Disables motors. bcuz it werkz?
     */
    public void disable() {
        frontLeftTwist.disable();
        frontRightTwist.disable();
        backLeftTwist.disable();
        backRightTwist.disable();
    }

    /**
     * Drives the robot based on parameter values
     * 
     * @param directionX Proportional speed at which to move left to right
     * @param directionY Proportional speed at which to move front to back
     * @param rotation   Proportional speed at which to rotate
     * @param useGyro    Boolean for field-oriented driving
     * @param slowSpeed  Boolean for slow mode to make the robot drive slower.
     * @param noPush     Boolean to lock wheels at 45 degree angles, to prevent the
     *                   robot from being pushed in any direction
     */
    public void drive(double directionX, double directionY, double rotation, boolean useGyro, boolean slowSpeed,
            boolean noPush) {
        swerve.drive(directionX, directionY, rotation, false, slowSpeed, noPush);
    }

    public void readGyro() {
        // SmartDashboard.putData(gyro);
    }

    public void setTolerances() {
        // .setPercentTolerance(0);

    }

    public void moveLeftOrRight(double power) {
        swerve.driveSimple(power, 270);
    }

    public void moveLeft() {
        swerve.driveSimple(-0.2, 270);
        // Robot.driveSystem.swerve.drive(-.3, 0, 0, false, false);
    }

    public void moveRight() {
        swerve.driveSimple(0.2, 270);
        // Robot.driveSystem.swerve.drive(.3, 0, 0, false, false);
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new Drive());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.

        // setDefaultCommand(new MySpecialCommand());
    }

    /**
     * The function which executes periodically to run the DriveTrain subsystem
     */
    @Override
    public void periodic() {
        // Put code here to be run every loop
        //SmartDashboard.putNumber("Front Right Encoder", frontRightEncoder.get());
        //SmartDashboard.putNumber("Front Left Encoder", frontLeftEncoder.get());
        // SmartDashboard.putNumber("Back Right Encoder", backRightEncoder.get());
        // SmartDashboard.putNumber("Back Left Encoder", backLeftEncoder.get());

        

        // lidarInches = lidarCrab.getDistance()*.4162533814 - 2.108536219;
        // System.out.println(lidarInches);
        // System.out.println(lidarCrab.getDistance());
    }

    /**
     * Indicates how much the robot needs to spin to align perpendicular to the
     * white line.
     * 
     * @return Rotational motor speed based on angle error. 0 if error is
     *         insignificant.
     */
    public double getSpinValue() {
        x0 = pixyData.getEntry("x0");
        x1 = pixyData.getEntry("x1");

        real_x0Array = x0.getDoubleArray(defaultValue);
        real_x1Array = x1.getDoubleArray(defaultValue);

        double mid0 = 0;
        double mid1 = 0;

        for (int x = 0; x < real_x0Array.length; x++) {
            if (x == 0) {
                mid0 = real_x0Array[0];
            } else if (Math.abs(real_x0Array[x] - 46) < Math.abs(mid0 - 46)) {
                mid0 = real_x0Array[x];
            }
        }

        for (int x = 0; x < real_x1Array.length; x++) {
            if (x == 0) {
                mid1 = real_x1Array[0];
            } else if (Math.abs(real_x1Array[x] - 46) < Math.abs(mid1 - 46)) {
                mid1 = real_x1Array[x];
            }
        }

        if (mid0 < mid1 && Math.abs(mid0 - mid1) > 3) {
            System.out.println("Right");
            return (.25);
        } else if (Math.abs(mid0 - mid1) > 3) {
            System.out.println("Left");
            return (-.25);
        }

        return 0;
    }

    /**
     * Gets the error of robot position versus white line position.
     * 
     * @return Translational motor speed based on the position error. 0 if the error
     *         is insignificant
     */
    public double getError() {
        x0 = pixyData.getEntry("x0");
        x1 = pixyData.getEntry("x1");

        real_x0Array = x0.getDoubleArray(defaultValue);
        real_x1Array = x1.getDoubleArray(defaultValue);

        double mid0 = 0;
        double mid1 = 0;

        for (int x = 0; x < real_x0Array.length; x++) {
            if (x == 0) {
                mid0 = real_x0Array[0];
            } else if (Math.abs(real_x0Array[x] - 46) < Math.abs(mid0 - 46)) {
                mid0 = real_x0Array[x];
            }
        }

        for (int x = 0; x < real_x1Array.length; x++) {
            if (x == 0) {
                mid1 = real_x1Array[0];
            } else if (Math.abs(real_x1Array[x] - 46) < Math.abs(mid1 - 46)) {
                mid1 = real_x1Array[x];
            }
        }

        double x_difference = ((mid0 + mid1) / 2);

        if (x_difference > 3) {
            error = computePIDPower(x_difference, 46);
            System.out.println(-error * 3);
            return -error * 3.75;
        }
        System.out.println(error);
        return 0;
    }

    public boolean centerOnLine()
    {
        if (getError() != 0 && getSpinValue() != 0)
        {
            return true;
        }
        else
        {
            Robot.driveTrain.drive(-Robot.driveTrain.getError(), -Robot.oi.joystick1.getRawAxis(1), -Robot.driveTrain.getSpinValue(), false, false, false);
        }

        return false;
    }

    /**
     * Checks to see if camera sees any objects
     * 
     * @return Boolean. true if camera sees an object. false otherwise
     */
    public boolean getSee() {
        NetworkTableEntry canSee = pixyData.getEntry("x0");
        double[] canSee2 = canSee.getDoubleArray(defaultValue);
        if (canSee2.length == 0) {
            System.out.println("See no");
            return false;
        }
        return true;
    }

    long lastTime;
    public double output = 0;
    public double errSum, lastErr = 0;
    double kp = 0.003;
    double ki = 0;

    /**
     * A method to compute PID motor power.
     * 
     * @return A double indicating how much to power a motor
     * @param input    This is the current value being received from the sensor
     * @param setpoint The desired setpoint
     */
    public double computePIDPower(double input, double setpoint) {
        /* How long since we last calculated */
        long now = System.currentTimeMillis();
        double timeChange = (double) (now - lastTime);
        /* Compute all the working error variables */
        double error = setpoint - input;
        errSum += (error * timeChange);

        /* Compute PID Output */
        output = kp * error + ki * errSum;

        /* Remember some variables for next time */
        lastErr = error;
        lastTime = now;

        return output;
    }
    public void disableFRD(){
        frontRightDrive.disable();
    }
    public void disableFLD(){
        frontLeftDrive.disable();
    }
    public void disableBRD(){
        backRightDrive.disable();
    }
    public void disableBLD(){
        backLeftDrive.disable();
    }
    public void disableFRT(){
        frontRightSwerve.disable();
    }
    public void disableFLT(){
        frontLeftSwerve.disable();
    }
    public void disableBRT(){
        backRightSwerve.disable();
    }
    public void disableBLT(){
        backLeftSwerve.disable();
    }
}
