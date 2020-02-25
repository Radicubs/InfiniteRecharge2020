package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ArcadeDrive extends Command {

  // 0.4 for Slow mode, 1 for fast mode
  private static double driveMode = 1;

  public ArcadeDrive() {

    requires(Robot.driveBase);
  }


  @Override
  protected void initialize() {}

  @Override
  protected void execute() {

    // Get Raw Axis Amounts
    double rawSpeed = Robot.oi.controller.getRawAxis(RobotMap.LEFT_Y_AXIS);
    double rawRotation = Robot.oi.controller.getRawAxis(RobotMap.RIGHT_X_AXIS);

    // Make Controller values less sensitive; easier for the user to use
    double scaledSpeed =
        Math.copySign(Math.pow(rawSpeed, 4), rawSpeed); // copy sign to maintain direction
    double scaledRotation = Math.copySign(Math.pow(rawRotation, 2), rawRotation);

    // Calculate the amount output for each motor
    double leftOut = (scaledSpeed - scaledRotation);
    double rightOut = (scaledSpeed + scaledRotation);

    leftOut *= driveMode;
    rightOut *= driveMode;

    // Drive!
    Robot.driveBase.drive(-leftOut, rightOut);
  }

  @Override
  protected boolean isFinished() {
    // Make this return true when this Command no longer needs to run execute()
    return false;
  }

  public static void changeDriveMode(){
      if (driveMode == 1.0){
        driveMode = 0.4;
      }else{
        driveMode = 1.0;
      }
  }

  @Override
  protected void end() {}

  @Override
  protected void interrupted() {
    super.interrupted();
  }
}
