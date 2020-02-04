package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class IndexBall extends Command {

private int indexTime;

  public IndexBall() {

    requires(Robot.index);
  }

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {

    Robot.index.drive(1, 1);
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
