package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

public class OI {
  public static Joystick controller = new Joystick(RobotMap.JOYSTICK);
  public static Button aButton = new JoystickButton(controller, RobotMap.A_BUTTON);
  public static Button xButton = new JoystickButton(controller, RobotMap.X_BUTTON);
  public static Button yButton = new JoystickButton(controller, RobotMap.Y_BUTTON);
  public static Button bButton = new JoystickButton(controller, RobotMap.B_BUTTON);

  public static Button leftBottomButton = new JoystickButton(controller, RobotMap.LB_BUTTON);
  public static Button rightBottomButton = new JoystickButton(controller, RobotMap.RB_BUTTON);

  public OI() {
    aButton.whenPressed(new AimX());
  }
}
