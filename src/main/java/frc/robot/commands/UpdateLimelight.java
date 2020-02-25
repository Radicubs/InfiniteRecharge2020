package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class UpdateLimelight extends Command {
  private NetworkTable target;

  public UpdateLimelight() {
    requires(Robot.limeLight);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    target = Robot.limeLight.getTable();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.limeLight.setValues();
    Robot.limeLight.readValues();
    // System.out.println(Robot.limeLight.calculateDistance());
  }

  // Make this return true when this Command no longer needs to run execute()
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
