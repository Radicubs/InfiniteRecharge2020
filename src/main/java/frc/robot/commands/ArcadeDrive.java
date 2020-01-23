package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ArcadeDrive extends Command {
  public ArcadeDrive() {

     requires(Robot.driveBase);
  }

  @Override
  protected void initialize() {

  }

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

    Robot.driveBase.drive(leftOut, rightOut);
  }

  double getScale(double x, double y) {
    return (1 / Math.max(x, y));
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
