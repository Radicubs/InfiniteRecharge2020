package frc.robot.commands.testingcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class IndexBallTwo extends Command{
  private double speed;
  
  public IndexBallTwo(double speed) {
    requires(Robot.index);
    this.speed = speed;
  }

  @Override
  protected void execute() {
      Robot.index.index(speed);

  }

  @Override
  protected boolean isFinished() {
    // Make this return true when this Command no longer needs to run execute()
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
    super.interrupted();
  }
}