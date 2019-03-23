/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc3707.Creedence.commands;

import org.usfirst.frc3707.Creedence.Robot;
import org.usfirst.frc3707.Creedence.pixy2API.Pixy2Line.Vector;

import edu.wpi.first.wpilibj.command.Command;

public class GrabLine extends Command {

  private boolean haveBlocks;
  private int blocksInQuestion;
  private static final int maxBadBlockCycles = 10;
  private Vector[] vectors;

  public GrabLine() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_pixy);
    this.haveBlocks = false;
    this.blocksInQuestion = 0;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    this.vectors= Robot.m_pixy.findVectors();

    if (vectors != null)
    {
      for (Vector block : this.vectors)
      {
        System.out.print("X0: " + block.getX0() + "\n");
        System.out.print("Y0: " + block.getY0() + "\n");
        System.out.print("X1: " + block.getX1() + "\n");
        System.out.print("Y1: " + block.getY1() + "\n");
      }
    }
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
