package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ManualIndex extends Command{

  public ManualIndex() {
    requires(Robot.index);
  }

  // Time to Run command (use it for distance as well)

  @Override
  protected void initialize() {
      } 

@Override
  protected void execute() {
      Robot.index.index(0.4);
}

  @Override
  protected boolean isFinished() {
    // Make this return true when this Command no longer needs to run execute()
    return false;
  }

  @Override
  protected void end() {
      Robot.index.index(0);
  }

  @Override
  protected void interrupted() {
    super.interrupted();
  }
}