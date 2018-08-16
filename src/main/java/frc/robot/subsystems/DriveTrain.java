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
  private double speedMultiplier;

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
  public void setTurbo(boolean val){
    if(val){
      speedMultiplier = 1.0;
    }else{
      speedMultiplier = 0.3;
    }
  }

  public void setCurvatureDrive(double speed, double turn, boolean classic){
    drive.curvatureDrive(speed * speedMultiplier, turn , classic);
  }

  public void setArcadeDrive(double throttle, double turn){
    drive.arcadeDrive(throttle * speedMultiplier, turn * speedMultiplier);
  }


}
