package frc.robot.commands.archive.automaticcommands;

//package frc.robot.commands.automaticcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class IntakeBallAutomatic extends Command{
  private double speed;
  
  public IntakeBallAutomatic(double speed) {
    requires(Robot.intake);
    this.speed = speed;
  }

  @Override
  protected void execute() {
      Robot.intake.takeIn(speed);

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