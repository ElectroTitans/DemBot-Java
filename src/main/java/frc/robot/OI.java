/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  private Joystick joyBoyDriveL = null;
  private Joystick joyBoyDriveR = null;

  private Joystick joyboyGamer = null;


  private JoystickButton buttonTurbo = null;
  private JoystickButton buttonIntakeClose = null;
  private JoystickButton buttonIntakeOpen  = null;
  private JoystickButton buttonIntakeIn    = null;
  private JoystickButton buttonIntakeOut   = null;

  public OI() {
    joyBoyDriveL = new Joystick(0);
    joyBoyDriveR = new Joystick(1);
    joyboyGamer  = new Joystick(2);

    buttonTurbo  = new JoystickButton(joyBoyDriveL, 0);

    buttonIntakeIn = new JoystickButton(joyboyGamer, 1);
    buttonIntakeOut = new JoystickButton(joyboyGamer, 2);
    
    
  }

  public double getThrottle(){
    return 0;
  }

  public double getTurn(){
    return 0;
  }

  public double getSuperStructureRotate(){
    return 0;
  }
}
