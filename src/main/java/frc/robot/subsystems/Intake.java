/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Intake extends Subsystem {
  private Spark intakeWheelSpark;
  private DoubleSolenoid intakeArms;

  public Intake(){
    intakeWheelSpark = new Spark(RobotMap.kIntakeSpark);
    intakeArms = new DoubleSolenoid(RobotMap.kPCMIntakeOpen, RobotMap.kPCMIntakeClose);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void SetArms(boolean isClosed){
    if(isClosed){
      intakeArms.set(Value.kForward);
    }else{
      intakeArms.set(Value.kReverse);
    }
  }

  public void SetWheels(double value){
    intakeWheelSpark.set(value);
  }

  public void Disable(){
    intakeArms.set(Value.kOff);
    intakeWheelSpark.disable();
  }

}
