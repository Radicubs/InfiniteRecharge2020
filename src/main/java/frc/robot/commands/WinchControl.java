package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class WinchControl extends Command {

  public WinchControl() {
    requires(Robot.winch);
  }

  // Time to Run command (use it for distance as well)

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {
    Robot.winch.winchRise(0.5);
   }

  @Override
  protected boolean isFinished() {
    // Make this return true when this Command no longer needs to run execute()
    return false;
  }

  @Override
  protected void end() {
    Robot.winch.winchRise(0);
  }

  @Override
  protected void interrupted() {
    super.interrupted();
  }
}
