package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ArcadeDrive extends Command {
  private int debugVal = 0;

  public ArcadeDrive() {

    requires(Robot.driveBase);
  }

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {
    double rawSpeed = Robot.oi.controller.getRawAxis(RobotMap.LEFT_Y_AXIS);
    double rawRotation = Robot.oi.controller.getRawAxis(RobotMap.RIGHT_X_AXIS);

    double scaledSpeed = Math.pow(rawSpeed, 3);
    double scaledRotation = Math.pow(rawRotation, 3);

    /* Yash this won't work, talk to Ananth V
    double leftOut = 0.5 * (scaledSpeed + scaledRotation);
    double rightOut = 0.5 * (scaledSpeed - scaledRotation);
    */

    /* We need to get the maximum values at all times, while maintaining
    proportionality between x and y. getScale gets the scale that the values
    need to multiplied by so that one value IS ALWAYS 1. so we have the maximum
    motor power while maintaining proportionality */

    double leftOut = (scaledSpeed + scaledRotation);
    double rightOut = (scaledSpeed - scaledRotation);

    double scale = getScale(leftOut, rightOut);

    leftOut *= scale;
    rightOut *= scale;

    /*
    if (debugVal == 200) {
      System.out.println("Left: " + leftOut);
      System.out.println("Right: " + rightOut);
      System.out.println("rawSpeed: " + rawSpeed);
      System.out.println("scaledSpeed: " + scaledSpeed);
      System.out.println("rawRotation: " + rawRotation);
      System.out.println("===========================");
      System.out.println();
      debugVal = 0;
    }
    debugVal++;
    */

    Robot.driveBase.drive(-leftOut, -rightOut);
  }

  double getScale(double x, double y) {
    double max = Math.max(Math.abs(x), Math.abs(y));
    if (max < 0.03) {
      return 0;
    }
    return (1 / max);
  }

  @Override
  protected boolean isFinished() {
    // Make this return true when this Command no longer needs to run execute()
    return false;
  }

  @Override
  protected void end() {}

  @Override
  protected void interrupted() {
    super.interrupted();
  }
}
