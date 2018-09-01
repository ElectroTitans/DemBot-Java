/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.RotateSuperstructure;

/**
 * Add your docs here.
 */
public class Superstructure extends Subsystem {
  private Spark leftSpark;
  private Spark rightSpark;

  public Superstructure(){
    leftSpark = new Spark(RobotMap.kLeftSuperSpark);
    rightSpark = new Spark(RobotMap.kRightSuperSpark);

    leftSpark.setInverted(true);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new RotateSuperstructure());
  }

  public void Rotate(double value){
    leftSpark.set(value);
    rightSpark.set(value);
  }
}
