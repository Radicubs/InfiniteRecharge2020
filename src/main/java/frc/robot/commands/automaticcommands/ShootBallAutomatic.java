package frc.robot.commands.automaticcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class ShootBallAutomatic extends Command{
  private double speed;
  
  public ShootBallAutomatic(double speed) {
    requires(Robot.shooter);
    this.speed = speed;
  }

  @Override
  protected void execute() {
      Robot.shooter.shoot(speed);

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