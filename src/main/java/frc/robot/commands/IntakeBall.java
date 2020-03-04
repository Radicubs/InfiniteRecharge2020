package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class IntakeBall extends Command{
  private double speed;
  
  public IntakeBall(double speed) {
    requires(Robot.intake);
    this.speed = speed;
  }

  @Override
  protected void execute() {
      Robot.intake.intake(speed);

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