/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.RobotMap;
import frc.robot.commands.JoystickDriveCommand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private Spark lfSpark;
  private Spark lrSpark;
  private Spark rfSpark;
  private Spark rrSpark;

  private SpeedControllerGroup leftGroup;
  private SpeedControllerGroup rightGroup;

  private DifferentialDrive drive;

  public void init(){
    lfSpark = new Spark(RobotMap.kLeftFrontSpark);
    lrSpark = new Spark(RobotMap.kLeftRearSpark);
    rfSpark = new Spark(RobotMap.kRightFrontSpark);
    rrSpark = new Spark(RobotMap.kRightRearSpark);

    leftGroup = new SpeedControllerGroup(lfSpark, lrSpark);
    rightGroup = new SpeedControllerGroup(rfSpark, rrSpark);

    drive = new DifferentialDrive(leftGroup, rightGroup);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new JoystickDriveCommand());
  }

  public void setArcadeDrive(double throttle, double turn){
    drive.arcadeDrive(throttle, turn);
  }


}
