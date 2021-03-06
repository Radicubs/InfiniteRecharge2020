package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;
import frc.robot.commands.defaultcommands.*;
import frc.robot.commands.onofftoggles.*;

public class OI {
  public static Joystick controller = new Joystick(RobotMap.JOYSTICK);
  public static Button aButton = new JoystickButton(controller, RobotMap.A_BUTTON);
  public static Button xButton = new JoystickButton(controller, RobotMap.X_BUTTON);
  public static Button yButton = new JoystickButton(controller, RobotMap.Y_BUTTON);
  public static Button bButton = new JoystickButton(controller, RobotMap.B_BUTTON);
  public static Button leftBottomButton = new JoystickButton(controller, RobotMap.LB_BUTTON);
  public static Button rightBottomButton = new JoystickButton(controller, RobotMap.RB_BUTTON);


  public static Joystick LT = new Joystick(RobotMap.LT_AXIS);
  public static Joystick RT = new Joystick(RobotMap.RT_AXIS);
  
  public static Joystick buttonBoard = new Joystick(RobotMap.BUTTON_BOARD);
  public static Button topOne = new JoystickButton(buttonBoard, RobotMap.TOP_BUTTON_ONE);
  public static Button topTwo = new JoystickButton(buttonBoard, RobotMap.TOP_BUTTON_TWO);
  public static Button topThree = new JoystickButton(buttonBoard, RobotMap.TOP_BUTTON_THREE);
  public static Button topFour = new JoystickButton(buttonBoard, RobotMap.TOP_BUTTON_FOUR);
  public static Button bottomOne = new JoystickButton(buttonBoard, RobotMap.BOTTOM_BUTTON_ONE);
  public static Button bottomTwo = new JoystickButton(buttonBoard, RobotMap.BOTTOM_BUTTON_TWO);
  public static Button bottomThree = new JoystickButton(buttonBoard, RobotMap.BOTTOM_BUTTON_THREE);
  public static Button bottomFour = new JoystickButton(buttonBoard, RobotMap.BOTTOM_BUTTON_FOUR);

  public OI() {
    aButton.whenPressed(new DriveMode());
    topOne.whenPressed(new ManualAlign());
    topTwo.whileHeld(new Vomit());
    //    bottomFour.whileHeld( ); // CLIMB
    bottomThree.whileHeld(new ManualShoot(-1.0));
    bottomTwo.whileHeld(new ManualIndex());
    bottomOne.whenPressed(new IntakeState());
    topThree.whenPressed(new ArcadeDrive());
    topFour.whileHeld(new WinchControl()); // CLIMB
  }
}
