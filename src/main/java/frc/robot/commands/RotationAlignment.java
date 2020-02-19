package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RotationAlignment extends Command {
  public RotationAlignment() {

    requires(Robot.driveBase);
  }

  private boolean rotationFinished = false;

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {

    // Drive!
    // Robot.driveBase.drive(-0.1, 0.1);
    System.out.println(Robot.limeLight.getTable().getEntry("tx").getDouble(0.0));
    double x = Robot.limeLight.getTable().getEntry("tx").getDouble(0.0);
    if (x < 0) {
      Robot.driveBase.drive(x / 100, x / 100);
    } else if (x > 0) {
      Robot.driveBase.drive(x / 100, x / 100);
    }else{
      rotationFinished = true;
    }
  }

  @Override
  protected boolean isFinished() {
    // Make this return true when this Command no longer needs to run execute()
    return rotationFinished;
  }

  @Override
  protected void end() {}

  @Override
  protected void interrupted() {
    super.interrupted();
  }
}
