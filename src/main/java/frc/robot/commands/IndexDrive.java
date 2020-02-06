package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class IndexDrive extends Command {
  public IndexDrive() {
    requires(Robot.index);
  }

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {
    if (Robot.oi.yButton.get()) {
        Robot.index.indexBall(1);
    }else{
        Robot.index.indexBall(0);
    }
    
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
