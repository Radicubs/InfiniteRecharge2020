package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveBackward extends Command{
  private long timeToRun;
  public DriveBackward(long timeToRun) {
    requires(Robot.driveBase);
    this.timeToRun = timeToRun;
  }

  // Time to Run command (use it for distance as well)
    long endTime = System.currentTimeMillis() + timeToRun;

  @Override
  protected void initialize() {
      } 


  protected void execute() {
      Robot.driveBase.drive(-0.3,-0.3);
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