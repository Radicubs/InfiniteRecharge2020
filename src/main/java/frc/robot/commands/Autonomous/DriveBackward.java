package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveBackward extends Command{
  private long timeToRun;
  private double speed;
  public DriveBackward(long timeToRun, double speed) {
    requires(Robot.driveBase);
    this.timeToRun = timeToRun;
    this.speed = speed;
  }

  // Time to Run command (use it for distance as well)
    long endTime = System.currentTimeMillis() + timeToRun;

  @Override
  protected void initialize() {
      } 


  protected void execute() {
      Robot.driveBase.drive(speed,-speed);
  }

  @Override
  protected boolean isFinished() {
    // Make this return true when this Command no longer needs to run execute()
    return System.currentTimeMillis() > endTime;
  }

  @Override
  protected void end() {}

  @Override
  protected void interrupted() {
    super.interrupted();
  }
}