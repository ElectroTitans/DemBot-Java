/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class LEDInterface extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  // 000 = OFF
  // 001 = RAINBOW_CYLON
  // 010 = POLICE
  // 011 = CONSTRUCTION
  // 100 = RED_CYLON
  public enum LedMode {
    OFF, RAINBOY_CYLON, POLICE, CONSTRUCTION, RED_CYLON
  }

  private DigitalOutput ledPin1;
  private DigitalOutput ledPin2;
  private DigitalOutput ledPin3;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void setMode(LedMode mode) {
    switch (mode) {
    case OFF:
      ledPin1.set(false);
      ledPin2.set(false);
      ledPin3.set(false);
      break;

    case RAINBOY_CYLON:
      ledPin1.set(false);
      ledPin2.set(false);
      ledPin3.set(true);
      break;

    case POLICE:
      ledPin1.set(false);
      ledPin2.set(true);
      ledPin3.set(false);
      break;

    case CONSTRUCTION:
      ledPin1.set(false);
      ledPin2.set(true);
      ledPin3.set(true);
      break;

    case RED_CYLON:
      ledPin1.set(true);
      ledPin2.set(false);
      ledPin3.set(false);
      break;
    }
  }
}
