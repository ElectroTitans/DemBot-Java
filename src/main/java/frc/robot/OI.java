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
  private JoystickButton turboButton = null;
  
  public enum InputMode {
    SPLIT_JOYSTICK, GAMER_JOYSTICK, GAMER_RACING
  };

  private InputMode currentMode;

  public OI(InputMode mode) {
    currentMode = mode;
    switch (currentMode) {
    case SPLIT_JOYSTICK:
      joyBoyDriveL = new Joystick(0);
      joyBoyDriveR = new Joystick(1);


      break;

    case GAMER_JOYSTICK:
      joyboyGamer = new Joystick(0);
      turboButton = new JoystickButton(joyboyGamer, 7);
      turboButton.whenPressed(new SetDriveTurboCommand(true));
      turboButton.whenReleased(new SetDriveTurboCommand(false));
    case GAMER_RACING:
      joyboyGamer = new Joystick(0);
      break;
    }
  }

  public double getTurn() {
    double val = 0;
    switch (currentMode) {
    case SPLIT_JOYSTICK:
      val = joyBoyDriveR.getX();
      break;

    case GAMER_JOYSTICK:
      val = joyboyGamer.getZ(); // Idk
      break;

    case GAMER_RACING:
      val = joyboyGamer.getX(Hand.kRight);
      break;
    }
    return val;
  }

  public double getThrottle() {
    double val = 0;
    switch (currentMode) {
    case SPLIT_JOYSTICK:
      val = joyBoyDriveL.getY();
      break;

    case GAMER_JOYSTICK:
      val = joyboyGamer.getY(Hand.kLeft);
      break;

    case GAMER_RACING:
      val = (joyboyGamer.getRawAxis(2) * -1) + (joyboyGamer.getRawAxis(3) );
      break;
    }
    return val;
  }

  public boolean getAltDrive(){
    boolean val = false;
    switch (currentMode) {
    case SPLIT_JOYSTICK:
      val = joyBoyDriveL.getRawButton(3);
      break;

    case GAMER_JOYSTICK:
      val = joyboyGamer.getRawButton(4);
      break;

    case GAMER_RACING:
      val = joyboyGamer.getRawButton(4);
      break;
    }
    return val;
  }

  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
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
}
