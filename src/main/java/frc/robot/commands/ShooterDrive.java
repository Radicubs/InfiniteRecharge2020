package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ShooterDrive extends Command {
  public ShooterDrive() {
    requires(Robot.shooter);
  }

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {
    Robot.shooter.shoot();
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
