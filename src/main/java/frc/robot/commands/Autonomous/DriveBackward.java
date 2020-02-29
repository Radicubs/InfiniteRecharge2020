package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class DriveBackward extends InstantCommand {
  public DriveBackward() {
    super();
    requires(Robot.driveBase);
  }

  // Time to Run command (use it for distance as well)
    long endTime = System.currentTimeMillis() + 2000;

  @Override
  protected void initialize() {
    // Run shooter
    while (System.currentTimeMillis() < endTime) {
        Robot.driveBase.drive(1, 1);
      } 

  }
}