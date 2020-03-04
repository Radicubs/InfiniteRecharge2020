package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DynamicShooting extends Command {

  public DynamicShooting() {
    requires(Robot.shooter);
    requires(Robot.index);
}

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {
      // run indexer
      Robot.index.index(0.5);
      // run shooter
      Robot.shooter.shoot(1.0);

  }

  @Override
  protected boolean isFinished() {
    // Make this return true when this Command no longer needs to run execute()
    return false;
  }

  @Override
  protected void end() {
      // set both to zero
      Robot.index.index(0);
      Robot.shooter.shoot(0);
  }

  @Override
  protected void interrupted() {
    super.interrupted();
  }
}
