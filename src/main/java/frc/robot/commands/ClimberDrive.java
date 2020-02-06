package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ClimberDrive extends Command {
  public ClimberDrive() {
    requires(Robot.climber);
  }

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {
    /*
    if (Robot.oi.xButton.get()) {
      Robot.climber.climb();
    }
    */
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
